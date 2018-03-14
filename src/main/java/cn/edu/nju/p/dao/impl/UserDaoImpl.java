package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.UserDao;
import cn.edu.nju.p.dao.daoUtils.UserLevel;
import cn.edu.nju.p.po.UserPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public UserPO getUserInfo(String username) {
        String sql = "SELECT * FROM user_info WHERE username=" + '"' + username + '"';
        UserPO userPO = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UserPO userPO1 = new UserPO();
            userPO1.setUsername(resultSet.getString("username"));
            userPO1.setSex(resultSet.getString("sex"));
            userPO1.setPhoneNumber(resultSet.getString("phoneNumber"));
            userPO1.setEmail(resultSet.getString("email"));
            userPO1.setAddress(resultSet.getString("address"));
            userPO1.setUnit(resultSet.getString("unit"));
            userPO1.setRealName(resultSet.getString("realName"));
            userPO1.setIdentity(resultSet.getString("identity"));
            userPO1.setLevel(resultSet.getString("level"));
            userPO1.setBalance(resultSet.getString("balance"));
            userPO1.setIntegral(resultSet.getString("integral"));
            userPO1.setConsumption(resultSet.getString("consumption"));
            userPO1.setDescription(resultSet.getString("description"));
            return userPO1;
        });

        return userPO;

    }

    @Override
    public int modifyUserInfo(UserPO po) {

        String sql = "update user_info set username="+'"'+po.getUsername()+'"'+','+"sex="+'"'+po.getSex()+'"'+','+"phoneNumber="+'"'+po.getPhoneNumber()+'"'
                +','+"email="+'"'+po.getEmail()+'"'+','+"address="+'"'+po.getAddress()+'"'+','+"unit="+'"'+po.getUnit()+'"'+','+"realName="+'"'+po.getRealName()+'"'
                +','+"identity="+'"'+po.getIdentity()+'"'+','+"level="+'"'+po.getLevel()+'"'+','+"balance="+'"'+po.getBalance()+'"'+','+"integral="+'"'+po.getIntegral()+'"'
                +','+"consumption="+'"'+po.getConsumption()+'"'+','+"description="+'"'+po.getDescription()+'"';

        int success=jdbcTemplate.update(sql);
        return success;

    }

    @Override
    public int registerNewVenue(VenueRegisterAccountPO po) {
        String sql = "Insert into venue_account(venueName,address,manager,phoneNumber,seatA,seatB,seatC,total,message1,message2,message3,description,username,state,venueId) values " +
                "(" + '"' + po.getVenueName() + '"' + "," + '"' + po.getAddress() + '"' + "," + '"' + po.getManager() + '"' +
                "," + '"' + po.getPhoneNumber() + '"' + "," + '"' + po.getSeatA()
                + '"' + "," + '"' + po.getSeatB() + '"' + "," + '"' + po.getSeatC() + '"' + "," + '"' +
                po.getTotal() + '"' + "," + '"' + po.getMessage1()
                + '"' + "," + '"'+po.getMessage2()+'"'+','+'"'+po.getMessage3()+'"'+ ','+'"'+po.getDescription()+'"'+','+'"'+po.getUsername()+'"'+','+'"'+po.getState()+'"'+','+'"'+po.getVenueId()+'"'+
                ")";

        System.out.println(sql);
        int success=jdbcTemplate.update(sql);

        return success;
    }

    private RowMapper<UserPO> getUserMapper(){
        return (resultSet, i) -> {
            cn.edu.nju.p.po.UserPO userPO = new cn.edu.nju.p.po.UserPO();
            userPO.setUsername(resultSet.getString("username"));
            userPO.setSex(resultSet.getString("sex"));
            userPO.setPhoneNumber(resultSet.getString("phoneNumber"));
            userPO.setEmail(resultSet.getString("email"));
            userPO.setAddress(resultSet.getString("address"));
            userPO.setUnit(resultSet.getString("unit"));
            userPO.setRealName(resultSet.getString("realName"));
            userPO.setIdentity(resultSet.getString("identity"));
            userPO.setLevel(resultSet.getString("level"));
            userPO.setBalance(resultSet.getString("balance"));
            userPO.setIntegral(resultSet.getString("integral"));
            userPO.setConsumption(resultSet.getString("consumption"));
            userPO.setDescription(resultSet.getString("description"));
            return userPO;
        };
    }

    @Override
    public int adjustLevel(String username){
        UserPO userPO=getUserInfo(username);
        double consump=Double.valueOf(userPO.getConsumption());
        String level = "";

        if(consump<500){
            level= String.valueOf(UserLevel.vip0);
        }else if(consump<1000){
            level= String.valueOf(UserLevel.vip1);
        }else if(consump<5000){
            level=String.valueOf(UserLevel.vip2);
        }else if(consump<10000){
            level=String.valueOf(UserLevel.vip3);
        }else if(consump<50000){
            level=String.valueOf(UserLevel.vip4);
        }else{
            level=String.valueOf(UserLevel.vip5);
        }
        String sql1="update user_info set level="+'"'+level+'"'+"where username="+'"'+username+'"';
        int success=jdbcTemplate.update(sql1);

        return success;
    }


    @Override
    public int[] StopVip(String username) {
        String sql = "update user_info set level="+'"'+"vip0"+'"'+"where username="+'"'+username+'"';
        String sql1 = "update user_info set consumption="+'"'+"0"+'"'+"where username="+'"'+username+'"';
        int[] success=jdbcTemplate.batchUpdate(sql,sql1);
        return success;
    }

    @Override
    public List<String> getCreateTime(String username) {
        String sql = "select distinct createTime from orders";
        List<String> list = jdbcTemplate.queryForList(sql,String.class);
        return list;
    }

    @Override
    public List<String> getTotal(String username) {
        String sql = "select sum(total) from orders group by createTime";
        List<String> list = jdbcTemplate.queryForList(sql,String.class);
        return list;
    }
}
