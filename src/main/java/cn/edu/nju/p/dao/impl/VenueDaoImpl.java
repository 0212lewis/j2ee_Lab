package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.VenueDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenuePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc on 2018/3/6.
 */
@Repository
public class VenueDaoImpl implements VenueDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int modifyVenueInfo(VenuePO po) {
        String sql = "update venues set venueName="+'"'+po.getVenueName()+'"'+','+"address="+'"'+po.getAddress()+'"'+','+"total="+'"'+po.getTotalSeats()+'"'
                +','+"seatA="+'"'+po.getSeatA()+'"'+','+"seatB="+'"'+po.getSeatB()+'"'+','+"seatC="+'"'+po.getSeatC()+'"'+','+"manager="+'"'+po.getManager()+'"'
                +','+"phoneNumber="+'"'+po.getPhoneNumber()+'"'+','+"description="+'"'+po.getDescription()+'"'+','+"message1="+'"'+po.getMessage1()+'"'+','+"message2="+'"'+po.getMessage2()+'"'
                +','+"message3="+'"'+po.getMessage3()+'"' + "where venueId="+'"'+po.getVenueId()+'"';

        int success=jdbcTemplate.update(sql);
        return success;
    }

    @Override
    public List<ShowPlanPO> getPlans(String venueName) {

        String sql = "select * from show_plan where venueName="+'"'+venueName+'"';

        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());


        return showPlanPOS;
    }


    @Override
    public int getPermittedPlans(String venueName) {

        String sql = "select * from show_plan where venueName="+'"'+venueName+'"'+"and state="+'"'+"批准"+'"';

        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());

        int count = showPlanPOS.size();
        return count;
    }


    @Override
    public int getBackPlans(String venueName) {
        String sql = "select * from show_plan where venueName="+'"'+venueName+'"'+"and state="+'"'+"驳回"+'"';

        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());

        int count = showPlanPOS.size();
        return count;
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
            showPlanPO.setShowPrice(resultSet.getString("showPrice"));
            showPlanPO.setShowPlace(resultSet.getString("showPlace"));
            showPlanPO.setState(resultSet.getString("state"));
            showPlanPO.setCreateTime(resultSet.getString("createTime"));
            showPlanPO.setOpenTime(resultSet.getString("openTime"));
            return showPlanPO;
        };

    }

}
