package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.OrderDao;
import cn.edu.nju.p.po.OrderPO;
import cn.edu.nju.p.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
