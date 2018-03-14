package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.service.AdminService;
import cn.edu.nju.p.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pc on 2018/3/10.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/getAllCompletedPlans")
    public BaseResult getAllCompletedPlans(){
        return new BaseResult<>(0,adminService.getAllCompletedPlans());
    }

    @PostMapping("/getAllUncompletedPlans")
    public BaseResult getAllUncompletedPlans(){
        return new BaseResult<>(0,adminService.getAllUncompletedPlans());
    }
    @PostMapping("/getAllCompletedVenueModify")
    public BaseResult getAllCompletedVenueModify(){
        return new BaseResult<>(0,adminService.getAllCompletedVenueModify());
    }
    @PostMapping("/getAllUncompletedVenueModify")
    public BaseResult getAllUncompletedVenueModify(){
        return new BaseResult<>(0,adminService.getAllUncompletedVenueModify());
    }

    @PostMapping("/getAllCompletedRegister")
    public BaseResult getAllCompletedRegister(){
        return new BaseResult<>(0,adminService.getAllCompletedRegister());
    }

    @PostMapping("/getAllUncompletedRegister")
    public BaseResult getAllUncompletedRegister(){
        return new BaseResult<>(0,adminService.getAllUncompletedRegister());
    }

    @PostMapping("/getPermittedPlans")
    public BaseResult getPermittedPlans(){
        return new BaseResult<>(0,adminService.getPermittedPlans());
    }

    @PostMapping("/getBackPlans")
    public BaseResult getBackPlans(){
        return new BaseResult<>(0,adminService.getBackPlans());
    }

    @PostMapping("/getPermittedVenueModify")
    public BaseResult getPermittedVenueModify(){
        return new BaseResult<>(0,adminService.getPermittedVenueModify());
    }

    @PostMapping("/getBackVenueModify")
    public BaseResult getBackVenueModify(){
        return new BaseResult<>(0,adminService.getBackVenueModify());
    }

    @PostMapping("/getPermittedRegister")
    public BaseResult getPermittedRegister(){
        return new BaseResult<>(0,adminService.getPermittedRegister());
    }

    @PostMapping("/getBackRegister")
    public BaseResult getBackRegister(){
        return new BaseResult<>(0,adminService.getBackRegister());
    }

    @PostMapping("/getAuditPlans")
    public BaseResult getAuditPlans(){
        return new BaseResult<>(0,adminService.getAuditPlans());
    }

    @PostMapping("/getAuditVenueModify")
    public BaseResult getAuditVenueModify(){
        return new BaseResult<>(0,adminService.getAuditVenueModify());
    }

    @PostMapping("/getAuditRegister")
    public BaseResult getAuditRegister(){
        return new BaseResult<>(0,adminService.getAuditRegister());
    }

    @GetMapping("/permitPlans")
    public BaseResult permitPlans(@RequestParam String showName,@RequestParam String venueName){
        return new BaseResult<>(0,adminService.permitPlans(showName,venueName));
    }

    @GetMapping("/permitVenueModify")
    public BaseResult permitVenueModify(@RequestParam String venueName,@RequestParam String title){
        return new BaseResult<>(0,adminService.permitVenueModify(venueName,title));
    }

    @GetMapping("/permitRegister")
    public BaseResult permitRegister(@RequestParam String venueName,@RequestParam String username){
        return new BaseResult<>(0,adminService.permitRegister(venueName,username));
    }

    @GetMapping("/backPlans")
    public BaseResult backPlans(@RequestParam String showName,@RequestParam String venueName){
        return new BaseResult<>(0,adminService.backPlans(showName,venueName));
    }

    @GetMapping("/backVenueModify")
    public BaseResult backVenueModify(@RequestParam String venueName,@RequestParam String title){
        return new BaseResult<>(0,adminService.backVenueModify(venueName,title));
    }

    @GetMapping("/backRegister")
    public BaseResult backRegister(@RequestParam String venueName,@RequestParam String username){
        return new BaseResult<>(0,adminService.backRegister(venueName,username));
    }

    @PostMapping("/getVenueIncome")
    public BaseResult getVenueIncome(){
        return new BaseResult<>(0,statisticsService.getVenueIncome());
    }

    @GetMapping("/payMoney")
    public BaseResult payMoney(@RequestParam String venueName,@RequestParam String money){
        return new BaseResult<>(0,statisticsService.payMoney(venueName,money));
    }



}
