package cn.edu.nju.p.service;

import cn.edu.nju.p.po.IncomePO;

import java.util.List;

/**
 * Created by pc on 2018/3/12.
 */
public interface StatisticsService {
    /**
     * 根据用户名得到该用户的所有订单数
     */
    int getAllOrdersNumber(String username);

    /**
     * 根据用户名得到该用户的所有已完成订单数
     */

    int getAllCompletedOrdersNumber(String username);

    /**
     * 根据用户名得到该用户的所有退订单数
     */

    int getAllBackOrdersNumber(String username);

    /**
     * 根据用户名得到该用户的总消费
     */

    double getAllConsumption(String username);

    /**
     * 得到总场馆数
     */

    int getAllVenueNumber();

    /**
     * 根据场馆名得到该场馆的所有预定数
     */

    int getAllVenueReserve();


    /**
     * 根据场馆名得到该场馆的所有退订数
     */

    int getAllVenueBack();


    /**
     * 根据场馆名得到该场馆的应得收入
     */
    double getVenueIncome(String venueName);

    /**
     * 根据场馆名得到该场馆的实际收入
     */
    double getVenueActualIncome(String venueName);

    /**
     *得到总会员人数、vip1人数、vip2人数、vip3人数、vip4人数、vip5人数
     * 返回一个List<Integer>
     */
    List<Integer> getUserNumber();


    /**
     * 得到各级会员完成订单数
     */
    List<Integer> getUserCompletedOrderNumber();

    /**
     * 得到各级会员退款单数
     */
    List<Integer> getUserBackOrderNumber();

    /**
     * 得到各级会员消费
     */
    List<Double> getUserConsumption();

    /**
     * 得到场馆的收入情况
     */

    List<IncomePO> getVenueIncome();

    /**
     *
     */
    String payMoney(String venueName,String money);

}
