package cn.edu.nju.p.controller;
import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pc on 2018/3/5.
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public BaseResult getAllOrders(@RequestParam String username){
        return new BaseResult<>(0,orderService.getAllOrders(username));
    }

    @GetMapping("/getAllCompleted")
    public BaseResult getAllCompleted(@RequestParam String username){
        return new BaseResult<>(0,orderService.getAllCompletd(username));
    }

    @GetMapping("/getAllUncompleted")
    public BaseResult getAllUncompleted(@RequestParam String username){
        return new BaseResult<>(0,orderService.getAllUncompleted(username));
    }
    @GetMapping("/getAllRefund")
    public BaseResult getAllRefund(@RequestParam String username){
        return new BaseResult<>(0,orderService.getAllRefund(username));
    }


}
