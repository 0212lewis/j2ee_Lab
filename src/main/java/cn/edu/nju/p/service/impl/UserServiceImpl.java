package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.UserDao;
import cn.edu.nju.p.po.UserPO;
import cn.edu.nju.p.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
@Service
public class UserServiceImpl implements UserService{

     @Autowired
     private UserDao userDao;

    @Override
    public UserPO getUserInfo(String username) {
        UserPO po = userDao.getUserInfo(username);
        return po;
    }

    @Override
    public String modifyUserInfo(UserPO po) {
        int success=userDao.modifyUserInfo(po);

        String res="";
        if(success<1){
            res="更新失败请重试！";

        }else{
            res="更新成功！";

        }
        return res;
    }

    @Override
    public List<UserPO> getAllUsers() {
        return null;
    }
}
