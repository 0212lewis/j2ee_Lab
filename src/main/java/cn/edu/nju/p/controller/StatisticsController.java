package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2018/3/13.
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/getVipsNumber")
    public BaseResult getVipsNumber(){
        return new BaseResult<>(0,statisticsService.getUserNumber());
    }

    @PostMapping("/getVipCompletedOrders")
    public BaseResult getVipCompletedOrders(){
        return new BaseResult<>(0,statisticsService.getUserCompletedOrderNumber());
    }

    @PostMapping("/getVipBackOrders")
    public BaseResult getVipBackOrders(){
        return new BaseResult<>(0,statisticsService.getUserBackOrderNumber());
    }

    @PostMapping("/getVipConsumption")
    public BaseResult getVipConsumption(){
        return new BaseResult<>(0,statisticsService.getUserConsumption());
    }

    @PostMapping("/getVenueStatisticsInfo")
    public BaseResult getVenueStatisticsInfo(){
        int venueNumber = statisticsService.getAllVenueNumber();
        int venueReserve=statisticsService.getAllVenueReserve();
        int venueBack=statisticsService.getAllVenueBack();
        List<Integer> list = new ArrayList<>();
        list.add(venueNumber);
        list.add(venueReserve);
        list.add(venueBack);
        return new BaseResult<>(0,list);
    }


}
