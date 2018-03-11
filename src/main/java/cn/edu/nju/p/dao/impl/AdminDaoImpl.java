package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.AdminDao;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc on 2018/3/10.
 */
@Repository
public class AdminDaoImpl implements AdminDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ShowPlanPO> getAllCompletedPlans() {
        String sql="select * from show_plan where state="+'"'+"批准"+'"'+"or state="+'"'+"驳回"+'"';
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        return showPlanPOS;
    }

    @Override
    public List<ShowPlanPO> getAllUncompletedPlans() {
        String sql="select * from show_plan where state="+'"'+"待审核"+'"';
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        return showPlanPOS;
    }

    @Override
    public List<VenueModifyPO> getAllCompletedVenueModify() {
        String sql="select * from venue_modify where state="+'"'+"批准"+'"'+"or state="+'"'+"驳回"+'"';
        List<VenueModifyPO> venueModifyPOS = jdbcTemplate.query(sql,getVenueModifyMapper());
        return venueModifyPOS;
    }

    @Override
    public List<VenueModifyPO> getAllUncompletedVenueModify() {
        String sql="select * from venue_modify where state="+'"'+"待审核"+'"';
        List<VenueModifyPO> venueModifyPOS = jdbcTemplate.query(sql,getVenueModifyMapper());
        return venueModifyPOS;
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
            showPlanPO.setShowPlace(resultSet.getString("showPlace"));
            showPlanPO.setShowPrice(resultSet.getString("showPrice"));
            showPlanPO.setState(resultSet.getString("state"));
            showPlanPO.setCreateTime(resultSet.getString("createTime"));
            showPlanPO.setOpenTime(resultSet.getString("openTime"));
            showPlanPO.setSeatA(resultSet.getString("seatA"));
            showPlanPO.setSeatB(resultSet.getString("seatB"));
            showPlanPO.setSeatC(resultSet.getString("seatC"));
            return showPlanPO;
        };

    }

    @Override
    public int getPermittedPlans() {

        String sql = "select * from show_plan where state="+'"'+"批准"+'"';

        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        int count = showPlanPOS.size();
        return count;
    }

    @Override
    public int getBackPlans() {

        String sql = "select * from show_plan where state="+'"'+"驳回"+'"';

        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        int count = showPlanPOS.size();
        return count;
    }

    @Override
    public int getPermittedVenueModify() {
        String sql = "select * from venue_modify where state="+'"'+"批准"+'"';

        List<VenueModifyPO> venueModifyPOS = jdbcTemplate.query(sql,getVenueModifyMapper());
        int count = venueModifyPOS.size();
        return count;
    }

    @Override
    public int getBackVenueModify() {
        String sql = "select * from venue_modify where state="+'"'+"驳回"+'"';

        List<VenueModifyPO> venueModifyPOS = jdbcTemplate.query(sql,getVenueModifyMapper());
        int count = venueModifyPOS.size();
        return count;
    }

    @Override
    public List<VenueRegisterAccountPO> getAllCompletedRegister() {

        String sql = "select * from venue_account where state="+'"'+"批准"+'"'+"or state="+'"'+"驳回"+ '"';
        List<VenueRegisterAccountPO> venueRegisterAccountPOS = jdbcTemplate.query(sql,getRegisterVenueMapper());
        return venueRegisterAccountPOS;
    }

    @Override
    public List<VenueRegisterAccountPO> getAllUncompletedRegister() {
        String sql = "select * from venue_account where state="+'"'+"待审核"+'"';
        List<VenueRegisterAccountPO> venueRegisterAccountPOS = jdbcTemplate.query(sql,getRegisterVenueMapper());
        return venueRegisterAccountPOS;
    }


    @Override
    public int getPermittedRegister() {
        String sql = "select * from venue_account where state="+'"'+"批准"+'"';

        List<VenueRegisterAccountPO> venueRegisterAccountPOS = jdbcTemplate.query(sql,getRegisterVenueMapper());
        int count = venueRegisterAccountPOS.size();
        return count;
    }

    @Override
    public int getBackRegister() {
        String sql = "select * from venue_account where state="+'"'+"驳回"+'"';
        List<VenueRegisterAccountPO> venueRegisterAccountPOS = jdbcTemplate.query(sql,getRegisterVenueMapper());
        int count = venueRegisterAccountPOS.size();
        return count;
    }

    @Override
    public int getAuditPlans() {

        String sql = "select * from show_plan where state="+'"'+"待审核"+'"';
        List<ShowPlanPO> showPlanPOS = jdbcTemplate.query(sql,getShowMapper());
        int count = showPlanPOS.size();
        return count;
    }

    @Override
    public int getAuditVenueModify() {
        String sql = "select * from venue_modify where state="+'"'+"待审核"+'"';
        List<VenueModifyPO> venueModifyPOS = jdbcTemplate.query(sql,getVenueModifyMapper());
        int count = venueModifyPOS.size();
        return count;
    }

    @Override
    public int getAuditRegister() {
        String sql = "select * from venue_account where state="+'"'+"待审核"+'"';
        List<VenueRegisterAccountPO> venueRegisterAccountPOS = jdbcTemplate.query(sql,getRegisterVenueMapper());
        int count = venueRegisterAccountPOS.size();
        return count;
    }

    private RowMapper<VenueModifyPO> getVenueModifyMapper(){

        return (resultSet,i)->{
            VenueModifyPO venueModifyPO = new VenueModifyPO();
            venueModifyPO.setAddress(resultSet.getString("address"));
            venueModifyPO.setCreateTime(resultSet.getString("createTime"));
            venueModifyPO.setDescription(resultSet.getString("description"));
            venueModifyPO.setManager(resultSet.getString("manager"));
            venueModifyPO.setPhoneNumber(resultSet.getString("phoneNumber"));
            venueModifyPO.setVenueName(resultSet.getString("venueName"));
            venueModifyPO.setMessage1(resultSet.getString("message1"));
            venueModifyPO.setMessage2(resultSet.getString("message2"));
            venueModifyPO.setMessage3(resultSet.getString("message3"));
            venueModifyPO.setTitle(resultSet.getString("title"));
            venueModifyPO.setState(resultSet.getString("state"));
            venueModifyPO.setSeatA(resultSet.getString("seatA"));
            venueModifyPO.setSeatB(resultSet.getString("seatB"));
            venueModifyPO.setSeatC(resultSet.getString("seatC"));
            venueModifyPO.setTotalSeats(resultSet.getString("total"));
           return venueModifyPO;
        };

    }


    private RowMapper<VenueRegisterAccountPO> getRegisterVenueMapper(){
        return (resultSet,i)->{
            VenueRegisterAccountPO venueRegisterAccountPO = new VenueRegisterAccountPO();

            venueRegisterAccountPO.setUsername(resultSet.getString("username"));
            venueRegisterAccountPO.setAddress(resultSet.getString("address"));
            venueRegisterAccountPO.setVenueName(resultSet.getString("venueName"));
            venueRegisterAccountPO.setCreateTime(resultSet.getString("createTime"));
            venueRegisterAccountPO.setPhoneNumber(resultSet.getString("phoneNumber"));
            venueRegisterAccountPO.setDescription(resultSet.getString("description"));
            venueRegisterAccountPO.setState(resultSet.getString("state"));
            venueRegisterAccountPO.setTotal(resultSet.getString("total"));
            venueRegisterAccountPO.setSeatA(resultSet.getString("seatA"));
            venueRegisterAccountPO.setSeatB(resultSet.getString("seatB"));
            venueRegisterAccountPO.setSeatC(resultSet.getString("seatC"));
            venueRegisterAccountPO.setMessage1(resultSet.getString("message1"));
            venueRegisterAccountPO.setMessage2(resultSet.getString("message2"));
            venueRegisterAccountPO.setMessage3(resultSet.getString("message3"));
            venueRegisterAccountPO.setManager(resultSet.getString("manager"));

            return venueRegisterAccountPO;

        };
    }
}
