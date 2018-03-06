package cn.edu.nju.p.controller;

import cn.edu.nju.p.dto.BaseResult;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pc on 2018/3/6.
 */
@RestController
@RequestMapping("/Show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/getPlays")
    public BaseResult getPlays(){
        return new BaseResult<>(0,showService.getPlays());
    }

    @PostMapping("/getSports")
    public BaseResult getSports(){
        return new BaseResult<>(0,showService.getSports());
    }

    @PostMapping("/getConcerts")
    public BaseResult getConcerts(){
        return new BaseResult<>(0,showService.getConcerts());
    }
    @PostMapping("/getClassic")
    public BaseResult getClassic(){
        return new BaseResult<>(0,showService.getClassic());
    }

    @PostMapping("/releaseNewShow")
    public BaseResult releaseNewShow(@RequestBody ShowPlanPO po){
        return new BaseResult<>(0,showService.releaseNewShow(po));
    }


}
