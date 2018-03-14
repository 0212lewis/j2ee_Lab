package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.AdminDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
import cn.edu.nju.p.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2018/3/10.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<ShowPlanPO> getAllCompletedPlans() {
        return adminDao.getAllCompletedPlans();
    }

    @Override
    public List<ShowPlanPO> getAllUncompletedPlans() {
        return adminDao.getAllUncompletedPlans();
    }

    @Override
    public List<VenueModifyPO> getAllCompletedVenueModify() {
        return adminDao.getAllCompletedVenueModify();
    }

    @Override
    public List<VenueModifyPO> getAllUncompletedVenueModify() {
        return adminDao.getAllUncompletedVenueModify();
    }

    @Override
    public int getPermittedPlans() {
        return adminDao.getPermittedPlans();
    }

    @Override
    public int getBackPlans() {
        return adminDao.getBackPlans();
    }

    @Override
    public int getPermittedVenueModify() {
        return adminDao.getPermittedVenueModify();
    }

    @Override
    public int getBackVenueModify() {
        return adminDao.getBackVenueModify();
    }

    @Override
    public List<VenueRegisterAccountPO> getAllCompletedRegister() {
        return adminDao.getAllCompletedRegister();
    }

    @Override
    public List<VenueRegisterAccountPO> getAllUncompletedRegister() {
        return adminDao.getAllUncompletedRegister();
    }

    @Override
    public int getPermittedRegister() {
        return adminDao.getPermittedRegister();
    }

    @Override
    public int getBackRegister() {
        return adminDao.getBackRegister();
    }

    @Override
    public int getAuditPlans() {
        return adminDao.getAuditPlans();
    }

    @Override
    public int getAuditVenueModify() {
        return adminDao.getAuditVenueModify();
    }

    @Override
    public int getAuditRegister() {
        return adminDao.getAuditRegister();
    }


    @Override
    public String permitVenueModify(String venueName, String title) {
        int count=adminDao.permitVenueModify(venueName,title);
        String res="";
        if(count<1){
            res="批准失败！";
        }else{
            res="批准成功！";
        }
        return res;
    }

    @Override
    public String permitRegister(String venueName, String username) {
        int[] count=adminDao.permitRegister(venueName,username);
        String res="";
        if(count[0]<1||count[1]<1){
            res="批准失败！";
        }else{
            res="批准成功！";
        }
        return res;
    }

    @Override
    public String permitPlans(String showName, String venueName) {
        int count=adminDao.permitPlans(showName,venueName);
        String res="";
        if(count<1){
            res="批准失败！";
        }else{
            res="批准成功！";
        }
        return res;
    }

    @Override
    public String backVenueModify(String venueName, String title) {
        int count=adminDao.backVenueModify(venueName,title);
        String res="";
        if(count<1){
            res="驳回失败！";
        }else{
            res="驳回成功！";
        }
        return res;
    }

    @Override
    public String backRegister(String venueName, String username) {
        int count=adminDao.backRegister(venueName,username);
        String res="";
        if(count<1){
            res="驳回失败！";
        }else{
            res="驳回成功！";
        }
        return res;
    }

    @Override
    public String backPlans(String showName, String venueName) {
        int count=adminDao.backPlans(showName,venueName);
        String res="";
        if(count<1){
            res="驳回失败！";
        }else{
            res="驳回成功！";
        }
        return res;
    }
}
