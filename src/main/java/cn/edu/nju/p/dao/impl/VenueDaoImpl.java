package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.VenueDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
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
    public int modifyVenueInfo(VenueModifyPO po) {
        String sql = "insert into venue_modify(createTime,state,title,venueName,address,total,seatA,seatB,seatC,manager,phoneNumber,message1,message2,message3,description) values " + '('
                + '"'+po.getCreateTime()+'"'+','+ '"'+ po.getState()+'"'+','+'"'+po.getTitle()+'"'+','+'"'+po.getVenueName()+'"'+','+'"'+po.getAddress()+'"'
                + ','+'"'+po.getTotalSeats()+'"'+','+'"'+po.getSeatA()+'"'+','+'"'+po.getSeatB()+'"'+','+'"'+po.getSeatC()+'"'+','+'"'+po.getManager() +'"'
                + ','+'"'+po.getPhoneNumber()+'"'+','+'"'+po.getMessage1()+'"'+','+'"'+po.getMessage2()+'"'+','+'"'+po.getMessage3()+'"'+','+'"'+po.getDescription()+'"'+')';

        System.out.print(sql);
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
        String sql = "insert into show_plan(showName,showTime,type,description,venueName,manager,phoneNumber,showPlace,showPrice,state,createTime,openTime,seatA,seatB,seatC) values "+
                "(" + '"' + po.getShowName() + '"' + "," + '"' + po.getShowTime() + '"' + "," + '"' + po.getType() + '"' +
                "," + '"' + po.getDescription() + '"' + "," + '"' + po.getVenueName()
                + '"' + "," + '"' + po.getManager() + '"' + "," + '"' + po.getPhoneNumber() + '"' + "," + '"' +
                po.getShowPlace() + '"' + "," + '"' + po.getShowPrice() + '"' + ","+ '"' + po.getState() + '"'+','+'"'+po.getCreateTime()+'"'+','+'"'+po.getOpenTime()
                + '"'+','+'"'+po.getSeatA()+'"'+','+'"'+po.getSeatB()+'"'+','+'"'+po.getSeatC()+'"'
                + ")";

        System.out.print(sql);
        int success = jdbcTemplate.update(sql);
        return success;
    }

    @Override
    public int deletePlan(String showName) {
        String sql = "delete from show_plan where showName="+'"'+showName+'"';
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
            showPlanPO.setSeatA(resultSet.getString("seatA"));
            showPlanPO.setSeatB(resultSet.getString("seatB"));
            showPlanPO.setSeatC(resultSet.getString("seatC"));
            return showPlanPO;
        };

    }

}
