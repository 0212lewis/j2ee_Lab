package cn.edu.nju.p.service;

import cn.edu.nju.p.po.UserPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;
import org.apache.catalina.User;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
public interface UserService {

    UserPO getUserInfo(String username);

    String modifyUserInfo(UserPO po);

    List<UserPO> getAllUsers();

    String registerNewVenue(VenueRegisterAccountPO po);

    String adjustLevel(String username);

    String stopVip(String username);

    List<String> getCreateTime(String username);

    List<String> getTotal(String username);


}
