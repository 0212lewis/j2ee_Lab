package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
import cn.edu.nju.p.po.VenuePO;
import cn.edu.nju.p.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pc on 2018/3/6.
 */

@RestController
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping("/modifyVenueInfo")
    public BaseResult modifyVenueInfo(@RequestBody VenueModifyPO po){
        return new BaseResult<>(0,venueService.modifyVenueInfo(po));
    }

    @GetMapping("/getPlans")
    public BaseResult getPlans(@RequestParam String venueName){
        return  new BaseResult<>(0,venueService.getPlans(venueName));
    }
    @GetMapping("/getPermittedPlans")
    public BaseResult getPermittedPlans(@RequestParam String venueName){
        return  new BaseResult<>(0,venueService.getPermittedPlans(venueName));
    }

    @GetMapping("/getBackPlans")
    public BaseResult getBackPlans(@RequestParam String venueName){
        return  new BaseResult<>(0,venueService.getBackPlans(venueName));
    }

    @PostMapping("/releaseNewShow")
    public BaseResult releaseNewShow(@RequestBody ShowPlanPO po){
        return new BaseResult<>(0,venueService.releaseNewShow(po));
    }

    @GetMapping("/deletePlan")
    public BaseResult deletePlan(@RequestParam String showName){
        return new BaseResult<>(0,venueService.deletePlan(showName));
    }

    @GetMapping("/getVenues")
    public BaseResult getVenues(@RequestParam String username){
        return new BaseResult<>(0,venueService.getVenues(username));
    }
}
