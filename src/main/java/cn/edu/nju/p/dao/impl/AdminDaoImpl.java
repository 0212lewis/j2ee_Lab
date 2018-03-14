package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.AdminDao;
import cn.edu.nju.p.po.IncomePO;
import cn.edu.nju.p.po.ShowPlanPO;
import cn.edu.nju.p.po.VenueModifyPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

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
            showPlanPO.setShowId(resultSet.getString("showId"));
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


    @Override
    public int permitVenueModify(String venueName, String title) {
        String sql="update venue_modify set state="+'"'+"批准"+'"'+"where venueName="+'"'+venueName+'"'+"and title="+'"'+title+'"';
        int success=jdbcTemplate.update(sql);
        return success;
    }

    @Override
    public int[] permitRegister(String venueName, String username) {
        String sql="update venue_account set state="+'"'+"批准"+'"'+"where venueName="+'"'+venueName+'"'+"and username="+'"'+username+'"';

        String temp = "select * from venue_account where venueName="+'"'+venueName+'"'+"and username="+'"'+username+'"';

        VenueRegisterAccountPO venueRegisterAccountPO = jdbcTemplate.queryForObject(temp, (resultSet, i) -> {

            VenueRegisterAccountPO venueRegisterAccountPO1 = new VenueRegisterAccountPO();
            venueRegisterAccountPO1.setVenueId(resultSet.getString("venueId"));
            venueRegisterAccountPO1.setUsername(resultSet.getString("username"));
            venueRegisterAccountPO1.setAddress(resultSet.getString("address"));
            venueRegisterAccountPO1.setVenueName(resultSet.getString("venueName"));
            venueRegisterAccountPO1.setPhoneNumber(resultSet.getString("phoneNumber"));
            venueRegisterAccountPO1.setDescription(resultSet.getString("description"));
            venueRegisterAccountPO1.setState(resultSet.getString("state"));
            venueRegisterAccountPO1.setTotal(resultSet.getString("total"));
            venueRegisterAccountPO1.setSeatA(resultSet.getString("seatA"));
            venueRegisterAccountPO1.setSeatB(resultSet.getString("seatB"));
            venueRegisterAccountPO1.setSeatC(resultSet.getString("seatC"));
            venueRegisterAccountPO1.setMessage1(resultSet.getString("message1"));
            venueRegisterAccountPO1.setMessage2(resultSet.getString("message2"));
            venueRegisterAccountPO1.setMessage3(resultSet.getString("message3"));
            venueRegisterAccountPO1.setManager(resultSet.getString("manager"));

            return venueRegisterAccountPO1;
        });


        String venueId=getVenueId();

        String sql1 = "insert into venues(venueName,address,total,seatType,seatA,seatB,seatC,manager,phoneNumber,available,message1,message2,message3,description,venueId,actualIncome) values "+'('
                +'"'+ venueRegisterAccountPO.getVenueName()+'"'+','+'"'+venueRegisterAccountPO.getAddress()+'"'+','+'"'+venueRegisterAccountPO.getTotal()+'"'
                +','+'"'+"A/B/C"+'"'+','+'"'+venueRegisterAccountPO.getSeatA()+'"'+','+'"'+venueRegisterAccountPO.getSeatB()+'"'+','+'"'+venueRegisterAccountPO.getSeatC()+'"'
                +','+'"'+venueRegisterAccountPO.getManager()+'"'+','+'"'+venueRegisterAccountPO.getPhoneNumber()+'"'+','+'"'+"1"+'"'
                +','+'"'+venueRegisterAccountPO.getMessage1()+'"'+','+'"'+venueRegisterAccountPO.getMessage2()+'"'+','+'"'+venueRegisterAccountPO.getMessage3()+'"'+','+'"'+venueRegisterAccountPO.getDescription()+'"'
                +','+'"'+venueId+'"'+','+'"'+"0"+'"'
                +')';


        String insertVenueId="update venue_account set venueId="+'"'+venueId+'"'+"where venueName="+'"'+venueName+'"';
        int q=jdbcTemplate.update(insertVenueId);

        int[] success=jdbcTemplate.batchUpdate(sql,sql1);
        return success;
    }

    @Override
    public int permitPlans(String showName, String venueName) {
        String sql="update show_plan set state="+'"'+"批准"+'"'+"where showName="+'"'+showName+'"'+"and venueName="+'"'+venueName+'"';
        int success=jdbcTemplate.update(sql);
        System.out.println(success+"------------------------------------------------------");
        return success;
    }

    @Override
    public int backVenueModify(String venueName, String title) {
        String sql="update venue_modify set state="+'"'+"驳回"+'"'+ "where venueName="+'"'+venueName+'"'+"and title="+'"'+title+'"';
        int success=jdbcTemplate.update(sql);
        return success;
    }

    @Override
    public int backRegister(String venueName, String username) {
        String sql="delete from venue_account set state="+'"'+"驳回"+'"'+"where venueName="+'"'+venueName+'"'+"and username="+'"'+username+'"';
        int success=jdbcTemplate.update(sql);
        return success;
    }

    @Override
    public int backPlans(String showName, String venueName) {
        String sql="update show_plan set state="+'"'+"驳回"+'"'+"where showName="+'"'+showName+'"'+"and venueName="+'"'+venueName+'"';
        int success=jdbcTemplate.update(sql);

        return success;
    }

    private RowMapper<VenueModifyPO> getVenueModifyMapper(){

        return (resultSet,i)->{
            VenueModifyPO venueModifyPO = new VenueModifyPO();
            venueModifyPO.setAddress(resultSet.getString("address"));
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
            venueRegisterAccountPO.setVenueId(resultSet.getString("venueId"));

            return venueRegisterAccountPO;

        };
    }



    private String getVenueId(){
        String str="0123456789";
        Random r=new Random();
        String arr[]=new String [7];
        String verificationCode="";
        for(int i=0;i<7;i++)
        {
            int n=r.nextInt(6);

            arr[i]=str.substring(n,n+1);
            verificationCode+=arr[i];

        }
        return verificationCode;
    }
}
