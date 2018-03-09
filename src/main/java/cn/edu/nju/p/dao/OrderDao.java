package cn.edu.nju.p.dao;

import cn.edu.nju.p.po.OrderPO;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */

public interface OrderDao {

    List<OrderPO> getAllOrders(String username);

    int getAllCompletd(String username);

    int getAllUncompleted(String username);

    int getAllRefund(String username);

    int deleteOrder(String username,String orderId);
 }
