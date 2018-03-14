package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.AccountDao;
import cn.edu.nju.p.po.AccountPO;
import cn.edu.nju.p.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by pc on 2018/3/5.
 */
@Service
public class AccountServiceImpl implements AccountService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AccountDao accountDao;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public String sentSimpleEmail(String to) {

        String content = generateVerification();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("验证登录");
        message.setText("欢迎您登录Tickets! 您的验证码为"+content+"  请在收到后一分钟内完成登录！");

        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
        return content;
    }

    @Override
    public String register(String username, String email) {
        String result = "";
        try {
            int[] success=accountDao.register(username,email);
            if(success[0]<1&&success[1]<1){
                result = "该用户名和邮箱已存在！";
            }else if(success[0]<1||success[1]<1){
                result = "注册失败！";
            } else{
                result = "注册成功！";
            }
        }catch (DuplicateKeyException e){
            result="您输入的用户名或邮箱已存在！";
        }
       return result;
    }

    @Override
    public boolean checkAccount(String username, String email) {
        boolean q = false;

        List<AccountPO> poList = accountDao.checkAccount(username,email);
        if (poList.size()==1){
            q=true;
        }
        return q;
    }

    @Override
    public int venueLogin(String venueId, String venueName) {

        return accountDao.venueLogin(venueId,venueName);
    }

    @Override
    public String getAuthority(String username) {
        return accountDao.getAuthority(username);
    }

    /**
    生成随机四位验证码
     */
    public String generateVerification(){

        String str="abcdefghigklmnopqrstuvwxyz0123456789";
        Random r=new Random();
        String arr[]=new String [4];
        String verificationCode="";
        for(int i=0;i<4;i++)
        {
            int n=r.nextInt(31);

            arr[i]=str.substring(n,n+1);
            verificationCode+=arr[i];

        }
       return verificationCode;
    }
}
