package cn.edu.nju.p.service;

import cn.edu.nju.p.po.UserPO;
import org.apache.catalina.User;

/**
 * Created by pc on 2018/3/5.
 */
public interface UserService {

    UserPO getUserInfo(String username);

    void modifyUserInfo(UserPO po);



}
