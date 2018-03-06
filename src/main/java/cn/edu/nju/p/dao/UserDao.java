package cn.edu.nju.p.dao;

import cn.edu.nju.p.po.UserPO;

/**
 * Created by pc on 2018/3/5.
 */
public interface UserDao {

    UserPO getUserInfo(String username);

    int modifyUserInfo(UserPO po);

}
