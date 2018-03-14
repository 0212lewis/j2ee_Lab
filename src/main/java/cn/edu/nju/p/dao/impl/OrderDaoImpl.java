package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.OrderDao;
import cn.edu.nju.p.po.OrderPO;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by pc on 2018/3/5.
 */

@Repository
public class OrderDaoImpl implements OrderDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<OrderPO> getAllOrders(String username) {

        String sql = "select * from orders where username = " + '"' + username + '"';

        List<OrderPO> allOrderList = jdbcTemplate.query(sql,getOrderMapper());

        return allOrderList;
    }

    @Override
    public int getAllCompletd(String username) {

        String sql = "select * from orders where username="+'"'+username+'"'+"and state=" + '"'+"已完成"+ '"';
        List<OrderPO> poList = jdbcTemplate.query(sql,getOrderMapper());
        int count = poList.size();
        return count;
    }

    @Override
    public int getAllUncompleted(String username) {
        String sql = "select * from orders where username="+'"'+username+'"'+"and state=" + '"'+"待使用"+ '"';
        List<OrderPO> poList = jdbcTemplate.query(sql,getOrderMapper());
        int count = poList.size();
        return count;
    }

    @Override
    public int getAllRefund(String username) {
        String sql = "select * from orders where username="+'"'+username+'"'+"and state=" + '"'+"退款"+ '"';
        List<OrderPO> poList = jdbcTemplate.query(sql,getOrderMapper());
        int count = poList.size();
        return count;
    }

    @Override
    public int deleteOrder(String username, String orderId) {
        String sql = "delete from orders where username="+'"'+username+'"'+"and orderId="+'"'+orderId+'"';
        int success=jdbcTemplate.update(sql);
        return success;
    }


    @Override
    public ShowPlanPO getShow(String showId) {
        String sql="select * from show_plan where showId="+'"'+showId+'"';
        ShowPlanPO showPlanPO = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {

            ShowPlanPO showPlanPO1 = new ShowPlanPO();
            showPlanPO1.setShowId(resultSet.getString("showId"));
            showPlanPO1.setShowName(resultSet.getString("showName"));
            showPlanPO1.setShowTime(resultSet.getString("showTime"));
            showPlanPO1.setType(resultSet.getString("type"));
            showPlanPO1.setDescription(resultSet.getString("description"));
            showPlanPO1.setVenueName(resultSet.getString("venueName"));
            showPlanPO1.setManager(resultSet.getString("manager"));
            showPlanPO1.setPhoneNumber(resultSet.getString("phoneNumber"));
            showPlanPO1.setShowPlace(resultSet.getString("showPlace"));
            showPlanPO1.setShowPrice(resultSet.getString("showPrice"));
            showPlanPO1.setState(resultSet.getString("state"));
            showPlanPO1.setCreateTime(resultSet.getString("createTime"));
            showPlanPO1.setOpenTime(resultSet.getString("openTime"));
            showPlanPO1.setSeatA(resultSet.getString("seatA"));
            showPlanPO1.setSeatB(resultSet.getString("seatB"));
            showPlanPO1.setSeatC(resultSet.getString("seatC"));

            return showPlanPO1;
        });
        return showPlanPO;
    }


    @Override
    public String getLevel(String username) {

        String sql = "Select level from user_info where username=?";
        String level = jdbcTemplate.queryForObject(sql, new Object[] { username }, String.class);
        return level;
    }




    @Override
    public int[] buyTickets(OrderPO orderPO) {

        int[] result=new int[5];

        /*
        插入orders表数据，每次付款完成插入一条对应的订单记录
         */

        String sql = "insert into orders(username,level,orderId,createTime,showTime,seatType,seat,code,state,price,total,number,showName,venueName) values"
                +'('+'"'+orderPO.getUsername()+'"'+','+'"'+getLevel(orderPO.getUsername())+'"'+','+'"'+ orderPO.getOrderId()+'"'+','+'"'+ orderPO.getCreateTime()+'"'+','+'"'+ orderPO.getShowTime()+'"'
                +','+'"'+orderPO.getSeatType()+'"'+','+'"'+orderPO.getSeat()+'"'+','+'"'+orderPO.getCode()+'"'+','+'"'+orderPO.getState()+'"'+','+'"'+orderPO.getPrice()+'"'
                +','+'"'+orderPO.getTotal()+'"'+','+'"'+orderPO.getNumber()+'"'+','+'"'+orderPO.getShowName()+'"'+','+'"'+orderPO.getVenueName()+'"'+')';
//        System.out.print(sql);
        result[0]=jdbcTemplate.update(sql);

        /*
        从数据库取出该用户的总消费，并且更新总消费
         */
        String temp="select consumption from user_info where username=?";

        double consump = Double.valueOf(jdbcTemplate.queryForObject(temp,new Object[] { orderPO.getUsername() }, String.class));

        consump=consump+Double.valueOf(orderPO.getTotal());

        String updateConsump="update user_info set consumption="+'"'+String.valueOf(consump)+'"'+"where username="+'"'+orderPO.getUsername()+'"';

        System.out.print(updateConsump);
        result[1] = jdbcTemplate.update(updateConsump);

         /*
        更新余额
         */
         String temp1 = "select balance from user_info where username=?";

         double balance = Double.valueOf(jdbcTemplate.queryForObject(temp1,new Object[]{orderPO.getUsername()},Double.class));

         balance = balance-Double.valueOf(orderPO.getTotal());

         String updateBalance="update user_info set balance="+'"'+String.valueOf(balance)+'"'+"where username="+'"'+orderPO.getUsername()+'"';

         result[3] = jdbcTemplate.update(updateBalance);

         /*
         更新积分
          */

        String temp2="select integral from user_info where username=?";

        double integral = Double.valueOf(jdbcTemplate.queryForObject(temp,new Object[] { orderPO.getUsername() }, String.class));

        integral=integral+Double.valueOf(orderPO.getTotal());

        String updateIntegral="update user_info set integral="+'"'+String.valueOf(integral)+'"'+"where username="+'"'+orderPO.getUsername()+'"';

        result[4] = jdbcTemplate.update(updateIntegral);
        /*
        插入一条新的记录到财务表
         */
        String sql1="insert into financial(username,consumption,createTime,venueName,venueId,level) values"+'('+'"'+orderPO.getUsername()+'"'
                +','+'"'+orderPO.getTotal()+'"'+','+'"'+orderPO.getCreateTime()+'"'+','+'"'+orderPO.getVenueName()+'"'+','+'"'+""+'"'
                +','+'"'+getLevel(orderPO.getUsername())+'"'+')';
        System.out.print(sql1);
        result[2]= jdbcTemplate.update(sql1);
        return result;
    }

    @Override
    public int updateSeats(String showName,String seatType, String seats) {
        String type="";
        String currentSeats="";


        if(seatType.equals("A")){
            type="seatA";
            currentSeats=getSeatA(showName);

        }else if(seatType.equals("B")){
            type = "seatB";
            currentSeats=getSeatB(showName);
        }else if(seatType.equals("C")){
            type = "seatC";
            currentSeats=getSeatC(showName);
        }

        System.out.print("seatType == "+type);

        System.out.print("first"+currentSeats);

        currentSeats=getFinalSeats(currentSeats,seats);

        String sql = "update show_plan set "+ type + "="+'"'+currentSeats+'"'+"where showName="+'"'+showName+'"';
        System.out.print(sql);
        int success = jdbcTemplate.update(sql);
        return success;
    }

    @Override
    public String getBalance(String username) {
        String temp1 = "select balance from user_info where username=?";

        double balance = Double.valueOf(jdbcTemplate.queryForObject(temp1,new Object[]{username},Double.class));

        return String.valueOf(balance);
    }

    @Override
    public String getIntegral(String username) {
        String temp1 = "select integral from user_info where username=?";

        double integral = Double.valueOf(jdbcTemplate.queryForObject(temp1,new Object[]{username},Double.class));

        return String.valueOf(integral);
    }


    @Override
    public String getCurrentSeats(String seatType, String showName) {
        String currentSeats = "";
        if(seatType.equals("A")){
            currentSeats = getSeatA(showName);
        }else if(seatType.equals("B")){
            currentSeats = getSeatB(showName);
        }else{
            currentSeats = getSeatC(showName);
        }
        return currentSeats;
    }

    private String getSeatA(String showName){
        String sql = "select seatA from show_plan where showName=?";
        String seatA = jdbcTemplate.queryForObject(sql,new Object[]{showName},String.class);
        return seatA;
    }

    private String getSeatB(String showName){
        String sql = "select seatB from show_plan where showName=?";
        String seatB = jdbcTemplate.queryForObject(sql,new Object[]{showName},String.class);
        return seatB;
    }
    private String getSeatC(String showName){
        String sql = "select seatC from show_plan where showName=?";
        String seatC = jdbcTemplate.queryForObject(sql,new Object[]{showName},String.class);
        return seatC;
    }

    private String getFinalSeats(String currentSeats,String seats){
        String result = "";

        String[] currentString = currentSeats.split(";");

        String[] seatsString = seats.split(";");


        List<String> currentlist = new ArrayList<String>();

        for (int i = 0; i < currentString.length; i++) {
            String current = currentString[i];
            boolean hasEquals = false;
            for (int j = 0; j < seatsString.length; j++) {
                String seat = seatsString[j];
                if (current.equals(seat)) {
                    hasEquals = true;
                    break;
                }
            }
            if (!hasEquals) {
                currentlist.add(current);
            }
        }

        System.out.println(currentlist+"after");
        return transformToString(currentlist);

    }

    private String transformToString(List<String> list){
        String result = "";
        for(int i=0;i<list.size();i++){
            result = result+list.get(i)+";";
        }
        result=result.substring(0,result.length()-1);
        return result;
    }

    private RowMapper<OrderPO> getOrderMapper(){
        return (resultSet, i) -> {
            cn.edu.nju.p.po.OrderPO orderPO = new cn.edu.nju.p.po.OrderPO();
            orderPO.setUsername(resultSet.getString("username"));
            orderPO.setLevel(resultSet.getString("level"));
            orderPO.setOrderId(resultSet.getString("orderId"));
            orderPO.setCreateTime(resultSet.getString("createTime"));
            orderPO.setShowName(resultSet.getString("showName"));
            orderPO.setShowTime(resultSet.getString("showTime"));
            orderPO.setCode(resultSet.getString("code"));
            orderPO.setSeatType(resultSet.getString("seatType"));
            orderPO.setSeat(resultSet.getString("seat"));
            orderPO.setNumber(resultSet.getString("number"));
            orderPO.setPrice(resultSet.getString("price"));
            orderPO.setTotal(resultSet.getString("total"));
            orderPO.setState(resultSet.getString("state"));
            orderPO.setVenueName(resultSet.getString("venueName"));
            return orderPO;
        };
    }
}
