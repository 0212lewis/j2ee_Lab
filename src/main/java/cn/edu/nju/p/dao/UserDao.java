package cn.edu.nju.p.dao;

import cn.edu.nju.p.po.OrderPO;
import cn.edu.nju.p.po.UserPO;
import cn.edu.nju.p.po.VenueRegisterAccountPO;

import java.util.List;

/**
 * Created by pc on 2018/3/5.
 */
public interface UserDao {

    UserPO getUserInfo(String username);

    int modifyUserInfo(UserPO po);

    int registerNewVenue(VenueRegisterAccountPO po);

    int adjustLevel(String username);

    int[] StopVip(String username);

    List<String> getCreateTime(String username);

    List<String> getTotal(String username);

}
