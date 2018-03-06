package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.VenueDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenuePO;
import cn.edu.nju.p.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ShowPlanPO> getPlans(String venueId) {
        return venueDao.getPlans(venueId);
    }
}
