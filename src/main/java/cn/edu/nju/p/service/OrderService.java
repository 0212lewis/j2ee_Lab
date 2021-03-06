package cn.edu.nju.p.service;

import cn.edu.nju.p.po.OrderPO;
import cn.edu.nju.p.po.ShowPlanPO;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
public interface OrderService {


    List<OrderPO> getAllOrders(String username);

    int getAllCompletd(String username);

    int getAllUncompleted(String username);

    int getAllRefund(String username);

    String deleteOrder(String username,String orderId);

    ShowPlanPO getShow(String showId);

    double getDiscount(String username);

    String buyTickets(OrderPO orderPO);

    String updateSeats(String showName,String seatType,String seats);


    String getBalance(String username);

    String getIntegral(String username);

    String getCurrentSeats(String seatType,String showName);


}
