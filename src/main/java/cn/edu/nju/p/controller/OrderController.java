package cn.edu.nju.p.controller;

import cn.edu.nju.p.dao.OrderDao;
import cn.edu.nju.p.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pc on 2018/3/5.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @PostMapping("/getAllOrders")
    public BaseResult getAllOrders(@RequestParam String username){
        return new BaseResult<>(0,orderDao.getAllOrders(username));
    }
}
