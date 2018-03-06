package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.ShowDao;
import cn.edu.nju.p.po.ShowPlanPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc on 2018/3/6.
 */
@Repository
public class ShowDaoImpl implements ShowDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ShowPlanPO> getAllShows() {
        String sql = "select * from show_plan";
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        return showPlanPOS;
    }

    @Override
    public List<ShowPlanPO> getPlays() {
        String sql = "select * from show_plan where type="+'"'+"戏剧达人"+'"';
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        return showPlanPOS;
    }

    @Override
    public List<ShowPlanPO> getConcerts() {
        String sql = "select * from show_plan where type="+'"'+"演唱会"+'"';
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        return showPlanPOS;
    }

    @Override
    public List<ShowPlanPO> getSports() {
        String sql = "select * from show_plan where type="+'"'+"体育赛事"+'"';
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        return showPlanPOS;
    }

    @Override
    public List<ShowPlanPO> getClassic() {
        String sql = "select * from show_plan where type="+'"'+"古典/舞蹈"+'"';
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        return showPlanPOS;
    }

    @Override
    public int releaseNewShow(ShowPlanPO po) {
        String sql = "insert into show_plan(showName,showTime,type,description,venueName,manager,phoneNumber,showPlace,showPrice,state,createTime,openTime) values "+
                "(" + '"' + po.getShowName() + '"' + "," + '"' + po.getShowTime() + '"' + "," + '"' + po.getType() + '"' +
                "," + '"' + po.getDescription() + '"' + "," + '"' + po.getVenueName()
                + '"' + "," + '"' + po.getManager() + '"' + "," + '"' + po.getPhoneNumber() + '"' + "," + '"' +
                po.getShowPlace() + '"' + "," + '"' + po.getShowPrice() + '"' + ","+ '"' + po.getState() + '"'+','+'"'+po.getCreateTime()+'"'+','+'"'+po.getOpenTime()
                + '"' + ")";

        int success = jdbcTemplate.update(sql);
        return success;
    }

    private RowMapper<ShowPlanPO> getShowMapper(){

        return (resultSet,i)->{
            ShowPlanPO showPlanPO = new ShowPlanPO();
            showPlanPO.setShowName(resultSet.getString("showName"));
            showPlanPO.setShowTime(resultSet.getString("showTime"));
            showPlanPO.setType(resultSet.getString("type"));
            showPlanPO.setDescription(resultSet.getString("description"));
            showPlanPO.setVenueName(resultSet.getString("venueName"));
            showPlanPO.setManager(resultSet.getString("manager"));
            showPlanPO.setPhoneNumber(resultSet.getString("phoneNumber"));
            showPlanPO.setShowPlace(resultSet.getString("showPrice"));
            showPlanPO.setState(resultSet.getString("state"));
            showPlanPO.setCreateTime(resultSet.getString("createTime"));
            showPlanPO.setOpenTime(resultSet.getString("openTime"));
            return showPlanPO;
        };

    }
}
