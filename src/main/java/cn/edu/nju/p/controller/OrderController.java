package cn.edu.nju.p.controller;
import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.po.OrderPO;
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

    @GetMapping("/deleteOrder")
    public BaseResult deleteOrder(@RequestParam String username,@RequestParam String orderId){
        return new BaseResult<>(0,orderService.deleteOrder(username,orderId));
    }

    @GetMapping("/getShow")
    public BaseResult getShow(@RequestParam String showId){
        return new BaseResult<>(0,orderService.getShow(showId));
    }

    @GetMapping("/getDiscount")
    public BaseResult getDiscount(@RequestParam String username){
        return new BaseResult<>(0,orderService.getDiscount(username));
    }

    @PostMapping("/buyTickets")
    public BaseResult buyTickets(@RequestBody OrderPO orderPO){
        return new BaseResult<>(0,orderService.buyTickets(orderPO));
    }


    @PostMapping("/getTicketNum")
    public BaseResult getTicketNum(){
        return new BaseResult<>(0,"1/2/3/4/5/6");
    }

    @GetMapping("/updateSeats")
    public BaseResult updateSeats(@RequestParam String showName,@RequestParam String seatType,@RequestParam String seats){
        return new BaseResult<>(0,orderService.updateSeats(showName,seatType,seats));
    }

    @GetMapping("/getBalance")
    public BaseResult getBalance(@RequestParam String username){
        return new BaseResult<>(0,orderService.getBalance(username));
    }

    @GetMapping("/getIntegral")
    public BaseResult getIntegral(@RequestParam String username){
        return new BaseResult<>(0,orderService.getIntegral(username));
    }

    @GetMapping("/getCurrentSeats")
    public BaseResult getCurrentSeats(@RequestParam String seatType,@RequestParam String showName){
        return new BaseResult<>(0,orderService.getCurrentSeats(seatType,showName));
    }
}
