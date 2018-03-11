package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.VenueDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
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
    public String modifyVenueInfo(VenueModifyPO po) {
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

        int seatACount = Integer.parseInt(po.getSeatA());
        int seatBCount = Integer.parseInt(po.getSeatB());
        int seatCCount = Integer.parseInt(po.getSeatC());

        String seatA = "";
        String seatB = "";
        String seatC = "";

        for(int i=1;i<seatACount;i++){
            seatA = seatA+String.valueOf(i)+";";
        }

        for(int i=1;i<seatBCount;i++){
            seatB = seatB+String.valueOf(i)+";";
        }
        for(int i=1;i<seatCCount;i++){
            seatC = seatC+String.valueOf(i)+";";
        }

        seatA = seatA+String.valueOf(seatACount);
        seatB = seatB+String.valueOf(seatBCount);
        seatC = seatC+String.valueOf(seatCCount);


        po.setSeatA(seatA);
        po.setSeatB(seatB);
        po.setSeatC(seatC);

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

    @Override
    public String deletePlan(String showName) {

        String res = "";
        int count = venueDao.deletePlan(showName);
        if(count<1){
            res="删除失败！";

        }else{
            res="删除成功！";

        }

        return res;
    }
}
