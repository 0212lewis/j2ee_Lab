package cn.edu.nju.p.service;

import cn.edu.nju.p.po.OrderPO;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
public interface OrderService {


    List<OrderPO> getAllOrders(String username);

    int getAllCompletd(String username);

    int getAllUncompleted(String username);

    int getAllRefund(String username);


}
