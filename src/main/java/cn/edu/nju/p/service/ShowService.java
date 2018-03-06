package cn.edu.nju.p.service;

import cn.edu.nju.p.po.ShowPlanPO;

import java.util.List;

/**
 * Created by pc on 2018/3/6.
 */
public interface ShowService {

    List<ShowPlanPO> getAllShows();

    List<ShowPlanPO> getPlays();

    List<ShowPlanPO> getConcerts();

    List<ShowPlanPO> getSports();

    List<ShowPlanPO> getClassic();

    String releaseNewShow(ShowPlanPO po);

}
