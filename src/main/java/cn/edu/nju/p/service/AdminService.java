package cn.edu.nju.p.service;

import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;

import java.util.List;

/**
 * Created by pc on 2018/3/10.
 */
public interface AdminService {
    List<ShowPlanPO> getAllCompletedPlans();

    List<ShowPlanPO> getAllUncompletedPlans();

    List<VenueModifyPO> getAllCompletedVenueModify();

    List<VenueModifyPO> getAllUncompletedVenueModify();

    List<VenueRegisterAccountPO> getAllCompletedRegister();

    List<VenueRegisterAccountPO> getAllUncompletedRegister();



    int getPermittedPlans();

    int getBackPlans();


    int getPermittedVenueModify();

    int getBackVenueModify();

    int getPermittedRegister();

    int getBackRegister();


    int getAuditPlans();

    int getAuditVenueModify();

    int getAuditRegister();

    String permitVenueModify(String venueName,String title);

    String permitRegister(String venueName,String username);

    String permitPlans(String showName, String venueName);

    String backVenueModify(String venueName,String title);

    String backRegister(String venueName,String username);

    String backPlans(String showName,String venueName);


}
