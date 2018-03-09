package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.po.UserPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
import cn.edu.nju.p.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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
}
