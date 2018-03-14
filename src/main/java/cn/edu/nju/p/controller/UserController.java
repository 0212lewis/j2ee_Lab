package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.po.UserPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
import cn.edu.nju.p.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public BaseResult getUserInfo(@RequestParam String username){
        UserPO po = userService.getUserInfo(username);
        return new BaseResult<>(0,po);
    }
    @PostMapping("/modifyUser")
    public BaseResult modifyUserInfo(@RequestBody UserPO po){
        return new BaseResult<>(0,userService.modifyUserInfo(po));

    }

    @PostMapping("/registerNewVenue")
    public  BaseResult registerNewVenue(@RequestBody VenueRegisterAccountPO po){
        return new BaseResult<>(0,userService.registerNewVenue(po));
    }

    @GetMapping("/adjustLevel")
    public BaseResult adjustLevel(@RequestParam String username){
        return new BaseResult<>(0,userService.adjustLevel(username));
    }

    @GetMapping("/stopVip")
    public BaseResult stopVip(@RequestParam String username){
        return new BaseResult<>(0,userService.stopVip(username));
    }

    @GetMapping("/getConsumptionByTime")
    public BaseResult getCreateTime(@RequestParam String username){

        List<List<String>> lists = new ArrayList<>();
        lists.add(userService.getCreateTime(username));
        lists.add(userService.getTotal(username));
        return new BaseResult<>(0,lists);
    }

    @GetMapping("/getTotal")
    public BaseResult getTotal(@RequestParam String username){
        return new BaseResult<>(0,userService.getTotal(username));
    }
}
