package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pc on 2018/3/10.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

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
}
