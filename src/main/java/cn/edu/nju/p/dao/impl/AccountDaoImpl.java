package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.AccountDao;
import cn.edu.nju.p.po.AccountPO;
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
    public int register(String username, String email) {

        String sql = "insert into account(username,email,authority) values"
                + "("
                + '"' + username + '"' + "," + '"' + email + '"' + "," + '"' + "1" + '"'
                + ")";

        int success = jdbcTemplate.update(sql);
return success;
    }

    @Override
    public List<AccountPO> getAllAccount() {
        return null;
    }


}
