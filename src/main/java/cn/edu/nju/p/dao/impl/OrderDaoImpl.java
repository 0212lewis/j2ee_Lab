package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.OrderDao;
import cn.edu.nju.p.po.AccountPO;
import cn.edu.nju.p.po.OrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        String sql = "select * from orders where username="+'"'+username+'"'+"and state=" + '"'+"退订"+ '"';
        List<OrderPO> poList = jdbcTemplate.query(sql,getOrderMapper());
        int count = poList.size();
        return count;
    }

    private RowMapper<OrderPO> getOrderMapper(){
        return (resultSet, i) -> {
            cn.edu.nju.p.po.OrderPO orderPO = new cn.edu.nju.p.po.OrderPO();
            orderPO.setOrderId(resultSet.getString("orderId"));
            orderPO.setCreateTime(resultSet.getString("createTime"));
            orderPO.setShowName(resultSet.getString("showName"));
            orderPO.setShowTime(resultSet.getString("showTime"));
            orderPO.setNum(resultSet.getString("number"));
            orderPO.setPrice(resultSet.getString("price"));
            orderPO.setTotal(resultSet.getString("total"));
            orderPO.setState(resultSet.getString("state"));
            return orderPO;
        };
    }
}
