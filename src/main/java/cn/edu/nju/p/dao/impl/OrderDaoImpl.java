package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.OrderDao;
import cn.edu.nju.p.po.OrderPO;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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

        int[] result=new int[3];

        /*
        插入orders表数据，每次付款完成插入一条对应的订单记录
         */
        String sql = "insert into orders(username,orderId,createTime,showTime,seatType,seat,code,state,price,total,number,showName,venueName) values"
                +'('+'"'+orderPO.getUsername()+'"'+','+'"'+ orderPO.getOrderId()+'"'+','+'"'+ orderPO.getCreateTime()+'"'+','+'"'+ orderPO.getShowTime()+'"'
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
        插入一条新的记录到财务表
         */
        String sql1="insert into financial(username,consumption,createTime,venueName,venueId,level) values"+'('+'"'+orderPO.getUsername()+'"'
                +','+'"'+orderPO.getTotal()+'"'+','+'"'+orderPO.getCreateTime()+'"'+','+'"'+orderPO.getVenueName()+'"'+','+'"'+""+'"'
                +','+'"'+getLevel(orderPO.getUsername())+'"'+')';
        System.out.print(sql1);
        result[2]= jdbcTemplate.update(sql1);
        return result;
    }




    private RowMapper<OrderPO> getOrderMapper(){
        return (resultSet, i) -> {
            cn.edu.nju.p.po.OrderPO orderPO = new cn.edu.nju.p.po.OrderPO();
            orderPO.setUsername(resultSet.getString("username"));
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
