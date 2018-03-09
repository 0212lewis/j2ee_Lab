package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;

/**
 * Created by pc on 2018/3/5.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/sendEmail")
    public BaseResult sendSimpleEmail(@RequestParam String to,@RequestParam String email){

        BaseResult baseResult;

        boolean result = accountService.checkAccount(to,email);

        if (result == true){
            String ver=accountService.sentSimpleEmail(email);

            baseResult = new BaseResult<>(0,ver);
        }else {
            baseResult = new BaseResult<>(1,"未注册的邮箱！");
        }
        return baseResult;
    }
    @GetMapping("/register")
    public BaseResult register(@RequestParam String username,@RequestParam String email){
        return new BaseResult<>(0,accountService.register(username,email));
    }


    @GetMapping("/venueLogin")
    public BaseResult venueLogin(@RequestParam String venueId, @RequestParam String venueName){

        String code = "";
        try {
            code = URLDecoder.decode(venueName,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("venueName:"+venueName);
        System.out.println("code:"+code);
        BaseResult baseResult;

        int result=accountService.venueLogin(venueId,code);
        if(result<1){
            baseResult=new BaseResult<>(4004,"用户名或密码错误!");
        }else{
            baseResult=new BaseResult<>(0000,"登录成功！");
        }
        return baseResult;
    }

}
