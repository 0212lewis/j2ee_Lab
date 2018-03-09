package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.ShowDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2018/3/6.
 */
@Service
public class ShowServiceImpl implements ShowService{
    @Autowired
    private ShowDao showDao;


    @Override
    public List<ShowPlanPO> getAllShows() {
        return showDao.getAllShows();
    }

    @Override
    public List<ShowPlanPO> getPlays() {
        return showDao.getPlays();
    }

    @Override
    public List<ShowPlanPO> getConcerts() {
        return showDao.getConcerts();
    }

    @Override
    public List<ShowPlanPO> getSports() {
        return showDao.getSports();
    }

    @Override
    public List<ShowPlanPO> getClassic() {
        return showDao.getClassic();
    }


}
