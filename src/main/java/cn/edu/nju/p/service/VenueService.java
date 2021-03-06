package cn.edu.nju.p.service;

import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
import cn.edu.nju.p.po.VenuePO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;

import java.util.List;

/**
 * Created by pc on 2018/3/6.
 */
public interface VenueService {

    String modifyVenueInfo(VenueModifyPO po);

    List<ShowPlanPO> getPlans(String venueName);

    int getPermittedPlans(String venueName);

    int getBackPlans(String venueName);

    String releaseNewShow(ShowPlanPO po);

    String deletePlan(String showName);

    List<VenueRegisterAccountPO> getVenues(String username);
}
