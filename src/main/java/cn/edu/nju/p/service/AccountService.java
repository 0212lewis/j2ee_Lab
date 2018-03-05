package cn.edu.nju.p.service;

/**
 * Created by pc on 2018/3/5.
 */
public interface AccountService {

    String sentSimpleEmail(String to);

    boolean checkAccount(String username,String email);

    String register(String username,String email);

}
