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
}
