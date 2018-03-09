package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.VenueDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenuePO;
import cn.edu.nju.p.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2018/3/6.
 */

@Service
public class VenueServiceImpl implements VenueService{

    @Autowired
    private VenueDao venueDao;

    @Override
    public String modifyVenueInfo(VenuePO po) {
        String res = "";
        int success = venueDao.modifyVenueInfo(po);
        if (success<1){
            res = "保存失败!";
        }else{
           res="保存成功!";
        }
        return res;
    }

    @Override
    public int getPermittedPlans(String venueName) {
        return venueDao.getPermittedPlans(venueName);
    }

    @Override
    public int getBackPlans(String venueName) {
        return venueDao.getBackPlans(venueName);
    }

    @Override
    public List<ShowPlanPO> getPlans(String venueName) {
        return venueDao.getPlans(venueName);
    }

    @Override
    public String releaseNewShow(ShowPlanPO po) {

        String result = "";
        try {
            int success = venueDao.releaseNewShow(po);
            if(success<1){
                result = "提交失败！";
            }else{
                result = "已提交申请！请等待管理员审核！";
            }
        }catch (DuplicateKeyException e){
            result = "发布的演出已存在！";
        }
        return result;
    }
}
