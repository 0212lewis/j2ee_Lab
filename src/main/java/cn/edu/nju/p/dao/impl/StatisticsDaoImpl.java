package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.StatisticsDao;
import cn.edu.nju.p.po.IncomePO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2018/3/12.
 */
@Repository
public class StatisticsDaoImpl implements StatisticsDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int getAllOrdersNumber(String username) {
        String sql = "select count(*) from orders where username=?";
        int count = jdbcTemplate.queryForObject(sql,new Object[]{username},Integer.class);
        return count;
    }

    @Override
    public int getAllCompletedOrdersNumber(String username) {
        String sql = "select count(*) from orders where username=?"+"and state="+'"'+"已完成"+'"';
        int count = jdbcTemplate.queryForObject(sql,new Object[]{username},Integer.class);
        return count;
    }

    @Override
    public int getAllBackOrdersNumber(String username) {
        String sql = "select count(*) from orders where username=?"+"and state="+'"'+"退款"+'"';
        int count = jdbcTemplate.queryForObject(sql,new Object[]{username},Integer.class);
        return count;
    }

    @Override
    public double getAllConsumption(String username) {
        String sql = "select consumption from orders where username=?";
        String count = jdbcTemplate.queryForObject(sql,new Object[]{username},String.class);
        return Double.valueOf(count);
    }

    @Override
    public int getAllVenueNumber() {
        String sql = "select count(*) from venues";
        int count = jdbcTemplate.queryForObject(sql,new Object[]{}, Integer.class);
        return count;
    }

    @Override
    public int getAllVenueReserve() {
        String sql = "select count(*) from orders where state=?" + "or state=?";
        int count = jdbcTemplate.queryForObject(sql,new Object[]{"已完成","待使用"},Integer.class);
        return count;
    }

    @Override
    public int getAllVenueBack() {
        String sql = "select count(*) from orders where state=?";
        int count = jdbcTemplate.queryForObject(sql,new Object[]{"退款"},Integer.class);
        return count;
    }

    @Override
    public double getVenueIncome(String venueName) {
        String sql = "select sum(consumption) from financial where venueName=?";
        double sum = jdbcTemplate.queryForObject(sql,new Object[]{venueName},Double.class);
        return sum;
    }

    @Override
    public double getVenueActualIncome(String venueName) {
        String sql = "select actualIncome from venues where venueName=?";
        double actualIncome = jdbcTemplate.queryForObject(sql,new Object[]{venueName},Double.class);
        return actualIncome;
    }

    @Override
    public List<Integer> getUserNumber() {
        List<Integer> userList = new ArrayList<Integer>();

        String sql = "select count(*) from user_info";
        int total = jdbcTemplate.queryForObject(sql,new Object[]{},Integer.class);
        userList.add(total);

        String sql1 = "select count(*) from user_info where level=?";
        int vip1 = jdbcTemplate.queryForObject(sql1,new Object[]{"vip1"},Integer.class);
        userList.add(vip1);
        String sql2 = "select count(*) from user_info where level=?";
        int vip2 = jdbcTemplate.queryForObject(sql2,new Object[]{"vip2"},Integer.class);
        userList.add(vip2);
        String sql3 = "select count(*) from user_info where level=?";
        int vip3 = jdbcTemplate.queryForObject(sql3,new Object[]{"vip3"},Integer.class);
        userList.add(vip3);
        String sql4 = "select count(*) from user_info where level=?";
        int vip4 = jdbcTemplate.queryForObject(sql4,new Object[]{"vip4"},Integer.class);
        userList.add(vip4);
        String sql5 = "select count(*) from user_info where level=?";
        int vip5 = jdbcTemplate.queryForObject(sql5,new Object[]{"vip5"},Integer.class);
        userList.add(vip5);
        return userList;
    }



    @Override
    public List<Integer> getUserCompletedOrderNumber() {
        List<Integer> userOrderNumberList = new ArrayList<Integer>();

        String sql = "select count(*) from orders where state=?";
        int total = jdbcTemplate.queryForObject(sql,new Object[]{"已完成"},Integer.class);
        userOrderNumberList.add(total);

        String sql1 = "select count(*) from orders where level=?"+"and state=?";
        int vip1 = jdbcTemplate.queryForObject(sql1,new Object[]{"vip1","已完成"},Integer.class);
        userOrderNumberList.add(vip1);
        String sql2 = "select count(*) from orders where level=?"+"and state=?";
        int vip2 = jdbcTemplate.queryForObject(sql2,new Object[]{"vip2","已完成"},Integer.class);
        userOrderNumberList.add(vip2);
        String sql3 = "select count(*) from orders where level=?"+"and state=?";
        int vip3 = jdbcTemplate.queryForObject(sql3,new Object[]{"vip3","已完成"},Integer.class);
        userOrderNumberList.add(vip3);
        String sql4 = "select count(*) from orders where level=?"+"and state=?";
        int vip4 = jdbcTemplate.queryForObject(sql4,new Object[]{"vip4","已完成"},Integer.class);
        userOrderNumberList.add(vip4);
        String sql5 = "select count(*) from orders where level=?"+"and state=?";
        int vip5 = jdbcTemplate.queryForObject(sql5,new Object[]{"vip5","已完成"},Integer.class);
        userOrderNumberList.add(vip5);

        return userOrderNumberList;
    }

    @Override
    public List<Integer> getUserBackOrderNumber() {
        List<Integer> userOrderNumberList = new ArrayList<Integer>();

        String sql = "select count(*) from orders where state=?";
        int total = jdbcTemplate.queryForObject(sql,new Object[]{"退款"},Integer.class);
        userOrderNumberList.add(total);

        String sql1 = "select count(*) from orders where level=?"+"and state=?";
        int vip1 = jdbcTemplate.queryForObject(sql1,new Object[]{"vip1","退款"},Integer.class);
        userOrderNumberList.add(vip1);
        String sql2 = "select count(*) from orders where level=?"+"and state=?";
        int vip2 = jdbcTemplate.queryForObject(sql2,new Object[]{"vip2","退款"},Integer.class);
        userOrderNumberList.add(vip2);
        String sql3 = "select count(*) from orders where level=?"+"and state=?";
        int vip3 = jdbcTemplate.queryForObject(sql3,new Object[]{"vip3","退款"},Integer.class);
        userOrderNumberList.add(vip3);
        String sql4 = "select count(*) from orders where level=?"+"and state=?";
        int vip4 = jdbcTemplate.queryForObject(sql4,new Object[]{"vip4","退款"},Integer.class);
        userOrderNumberList.add(vip4);
        String sql5 = "select count(*) from orders where level=?"+"and state=?";
        int vip5 = jdbcTemplate.queryForObject(sql5,new Object[]{"vip5","退款"},Integer.class);
        userOrderNumberList.add(vip5);

        return userOrderNumberList;
    }

    @Override
    public List<Double> getUserConsumption() {
        List<Double> userConsumptionList = new ArrayList<Double>();

        String sql = "select sum(consumption) from user_info";
        double total = jdbcTemplate.queryForObject(sql,new Object[]{},Double.class);
        userConsumptionList.add(total);

        String sql1 = "select sum(consumption) from user_info where level=?";
        double vip1 = jdbcTemplate.queryForObject(sql1,new Object[]{"vip1"},Double.class);
        userConsumptionList.add(vip1);
        String sql2 = "select sum(consumption) from user_info where level=?";
        double vip2 = jdbcTemplate.queryForObject(sql2,new Object[]{"vip2"},Double.class);
        userConsumptionList.add(vip2);
        String sql3 = "select sum(consumption) from user_info where level=?";
        double vip3 = jdbcTemplate.queryForObject(sql3,new Object[]{"vip3"},Double.class);
        userConsumptionList.add(vip3);
        String sql4 = "select sum(consumption) from user_info where level=?";
        double vip4 = jdbcTemplate.queryForObject(sql4,new Object[]{"vip4"},Double.class);
        userConsumptionList.add(vip4);
        String sql5 = "select sum(consumption) from user_info where level=?";
        double vip5 = jdbcTemplate.queryForObject(sql5,new Object[]{"vip5"},Double.class);
        userConsumptionList.add(vip5);
        return userConsumptionList;
    }


    @Override
    public List<IncomePO> getVenueIncome() {

        String sql = "select distinct venueName from financial";
        List<String> venueNames = jdbcTemplate.queryForList(sql,String.class);
        List<IncomePO> incomePOS = new ArrayList<>();
        for (int i = 0; i < venueNames.size(); i++) {
            IncomePO incomePO = new IncomePO();

            incomePO.setActualIncome(getVenueActualIncome(venueNames.get(i)));
            incomePO.setIncome(getVenueIncome(venueNames.get(i)));
            incomePO.setShouldPay(getVenueIncome(venueNames.get(i))*0.5);
            incomePO.setVenueName(venueNames.get(i));
            incomePOS.add(incomePO);
        }

        return incomePOS;
    }

    @Override
    public int payMoney(String venueName,String money) {

        String temp = "select actualIncome from venues where venueName=?";

        double actualIncome = jdbcTemplate.queryForObject(temp,new Object[]{venueName},Double.class);

        actualIncome = actualIncome+Double.valueOf(money);

        String sql = "update venues set actualIncome="+'"'+actualIncome+'"'+"where venueName="+'"'+venueName+'"';
        int success = jdbcTemplate.update(sql);
        return success;
    }
}
