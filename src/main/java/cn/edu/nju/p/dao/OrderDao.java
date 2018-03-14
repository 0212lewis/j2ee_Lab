package cn.edu.nju.p.dao;

import cn.edu.nju.p.po.OrderPO;
import cn.edu.nju.p.po.ShowPlanPO;

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

    ShowPlanPO getShow(String showId);

    String getLevel(String username);

    int[] buyTickets(OrderPO orderPO);

    int updateSeats(String showName,String seatType,String seats);

    String getBalance(String username);

    String getIntegral(String username);

    String getCurrentSeats(String seatType,String showName);

 }
