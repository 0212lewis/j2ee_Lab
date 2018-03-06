package cn.edu.nju.p.dao;

import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenuePO;

import java.util.List;

/**
 * Created by pc on 2018/3/6.
 */
public interface VenueDao {

    int modifyVenueInfo(VenuePO po);

    List<ShowPlanPO> getPlans(String venueName);

    int getPermittedPlans(String venueName);

    int getBackPlans(String venueName);
}
