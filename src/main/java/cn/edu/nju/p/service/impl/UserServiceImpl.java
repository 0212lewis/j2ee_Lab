package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.UserDao;
import cn.edu.nju.p.po.UserPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
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

    @Override
    public String registerNewVenue(VenueRegisterAccountPO po) {

        int count = userDao.registerNewVenue(po);

        String res="";
        if (count<1){
            res="提交失败！";
        }else {
            res="已提交申请";
        }

        return res;
    }

    @Override
    public String adjustLevel(String username) {
        int count=userDao.adjustLevel(username);
        String res="";
        if(count<1){
            res="等级更新失败！";
        }else{
            res="等级更新成功！";
        }
        return res;
    }

    @Override
    public String stopVip(String username) {
        String result = "";
        int[] count = userDao.StopVip(username);
        if(count[0]<1){
            result="停止会员特权失败!";
        }
        if(count[1]<1){
            result="清零consumption失败!";
        }
        if(count[0]>0&&count[1]>0){
            result="您已经停止了会员特权，该操作不可恢复!";
        }
        return result;
    }

    @Override
    public List<String> getCreateTime(String username) {
        return userDao.getCreateTime(username);
    }

    @Override
    public List<String> getTotal(String username) {
        return userDao.getTotal(username);
    }
}
