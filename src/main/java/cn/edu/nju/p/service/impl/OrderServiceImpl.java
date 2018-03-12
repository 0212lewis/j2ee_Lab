package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.OrderDao;
import cn.edu.nju.p.po.OrderPO;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by pc on 2018/3/6.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderPO> getAllOrders(String username) {
        return orderDao.getAllOrders(username);
    }

    @Override
    public int getAllCompletd(String username) {
        return orderDao.getAllCompletd(username);
    }

    @Override
    public int getAllUncompleted(String username) {
        return orderDao.getAllUncompleted(username);
    }

    @Override
    public int getAllRefund(String username) {
        return orderDao.getAllRefund(username);
    }

    @Override
    public String deleteOrder(String username, String orderId) {

        String res = "";

        int success=orderDao.deleteOrder(username,orderId);

        if(success<1){
            res="删除失败！";

        }else{
            res="删除成功！";
        }
        return res;
    }


    @Override
    public ShowPlanPO getShow(String showId) {
        return orderDao.getShow(showId);
    }

    @Override
    public double getDiscount(String username) {

        double discount = 0.0;

        String level=orderDao.getLevel(username);
        switch (level){
            case "vip1":{
                discount = 0.95;
                break;
            }
            case "vip2":{
                discount=0.9;
                break;
            }
            case  "vip3":{
                discount=0.85;
                break;
            }
            case "vip4":{
                discount=0.8;
                break;
            }
            case "vip5":{
                discount=0.7;
            }
        }
        return discount;
    }


    @Override
    public String buyTickets(OrderPO orderPO) {

        String orderId = getOrderId(orderPO.getUsername());
        String code = getCode();

        orderPO.setOrderId(orderId);
        orderPO.setCode(code);

        int[] res = orderDao.buyTickets(orderPO);

        System.out.print(String.valueOf(res[0])+"===="+String.valueOf(res[1])+"====="+String.valueOf(res[1]));
        String result="";

        if(res[0]<1){
         result="插入到订单表失败!";
        }
        if(res[1]<1){
            result="更新用户总消费失败!";
        }
        if(res[2]<1){
            result="插入到财务表失败!";
        }

        if(res[0]>0&&res[1]>0&&res[2]>0){
            result="购票成功！";
        }else{
            result="数据异常！";
        }
        return result;
    }


    private String getOrderId(String username){
        String orderId="";
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改

        String year = String.valueOf(c.get(Calendar.YEAR));

        String month = String.valueOf(c.get(Calendar.MONTH));

        String date = String.valueOf(c.get(Calendar.DATE));

        String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));

        String minute = String.valueOf(c.get(Calendar.MINUTE));

        String second = String.valueOf(c.get(Calendar.SECOND));

        orderId=year+month+ date +hour +minute + second +username;

        return orderId;
    }

    private String getCode(){
        String str="0123456";
        Random r=new Random();
        String arr[]=new String [7];
        String showId="";
        for(int i=0;i<7;i++)
        {
            int n=r.nextInt(6);

            arr[i]=str.substring(n,n+1);
            showId+=arr[i];

        }
        return showId;
    }
}
