package cn.edu.nju.p.dao;

import cn.edu.nju.p.po.AccountPO;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
public interface AccountDao {

    List<AccountPO> getAllAccount();

    List<AccountPO> checkAccount(String username,String email);

    int register(String username, String email);




//    boolean register(String username,String email);




}
