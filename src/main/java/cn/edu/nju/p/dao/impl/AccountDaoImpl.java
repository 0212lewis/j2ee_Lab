package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.AccountDao;
import cn.edu.nju.p.po.AccountPO;
import cn.edu.nju.p.po.VenuePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AccountPO> checkAccount(String username, String email) {

        String sql = "select * from account where username="+'"'+username+'"'+"and email="+'"'+email+'"';
        List<AccountPO> accountPOS = jdbcTemplate.query(sql ,(resultSet, i) -> {
            AccountPO accountPO1 = new AccountPO();
            accountPO1.setAuthority(resultSet.getString("authority"));
            accountPO1.setEmail(resultSet.getString("email"));
            accountPO1.setUsername(resultSet.getString("username"));
            return accountPO1;
        });
        return accountPOS;
    }

    @Override
    public int[] register(String username, String email){

        String sql = "insert into account(username,email,authority) values"
                + "("
                + '"' + username + '"' + "," + '"' + email + '"' + "," + '"' + "1" + '"'
                + ")";


        String sql1="insert into user_info(username,sex,phoneNumber,email,address,unit,realName,identity,level,balance,integral,consumption,description) values"
                + "("
                + '"' + username + '"' + "," + '"' + "" + '"' + "," + '"' + "" + '"'
                + "," + '"' + email + '"' + "," + '"' + "" + '"'
                + "," + '"' + "" + '"' + "," + '"' + "" + '"'
                + "," + '"' + "" + '"' + "," + '"' + "" + '"'
                + "," + '"' + "" + '"' + "," + '"' + "" + '"'
                + "," + '"' + "" + '"' + "," + '"' + "" + '"'
                + ")";

        String sqls[] = new String[2];
        sqls[0] = sql;
        sqls[1] = sql1;

        int[] success = jdbcTemplate.batchUpdate(sqls);
        return success;
    }


    @Override
    public int venueLogin(String venueId, String venueName) {
        int res=0;
        String sql = "select * from venues where venueId="+'"'+venueId+'"'+"and venueName="+'"'+venueName+'"';
        List<VenuePO> venuePOS = jdbcTemplate.query(sql ,(resultSet, i) -> {
            VenuePO venuePO = new VenuePO();
            venuePO.setVenueId(resultSet.getString("venueId"));
            venuePO.setVenueName(resultSet.getString("venueName"));
            return venuePO;
        });
        if(venuePOS.size()<1){
            res=0;
        }else{
            res=1;
        }
        return res;
    }

    @Override
    public int venueRegister(String username, VenuePO venuePO) {
        return 0;
    }

    @Override
    public List<AccountPO> getAllAccount() {
        return null;
    }


}
