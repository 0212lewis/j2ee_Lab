package cn.edu.nju.p.service.impl;

import cn.edu.nju.p.dao.StatisticsDao;
import cn.edu.nju.p.po.IncomePO;
import cn.edu.nju.p.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2018/3/12.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public int getAllOrdersNumber(String username) {
        return statisticsDao.getAllOrdersNumber(username);
    }

    @Override
    public int getAllCompletedOrdersNumber(String username) {
        return statisticsDao.getAllCompletedOrdersNumber(username);
    }

    @Override
    public int getAllBackOrdersNumber(String username) {
        return statisticsDao.getAllBackOrdersNumber(username);
    }

    @Override
    public double getAllConsumption(String username) {
        return statisticsDao.getAllConsumption(username);
    }

    @Override
    public int getAllVenueNumber() {
        return statisticsDao.getAllVenueNumber();
    }

    @Override
    public int getAllVenueReserve() {
        return statisticsDao.getAllVenueReserve();
    }

    @Override
    public int getAllVenueBack() {
        return statisticsDao.getAllVenueBack();
    }

    @Override
    public double getVenueIncome(String venueName) {
        return statisticsDao.getVenueIncome(venueName);
    }

    @Override
    public double getVenueActualIncome(String venueName) {
        return statisticsDao.getVenueActualIncome(venueName);
    }

    @Override
    public List<Integer> getUserNumber() {
        return statisticsDao.getUserNumber();
    }

    @Override
    public List<Integer> getUserCompletedOrderNumber() {
        return statisticsDao.getUserCompletedOrderNumber();
    }

    @Override
    public List<Integer> getUserBackOrderNumber() {
        return statisticsDao.getUserBackOrderNumber();
    }
    @Override
    public List<Double> getUserConsumption() {
        return statisticsDao.getUserConsumption();
    }

    @Override
    public List<IncomePO> getVenueIncome() {
        return statisticsDao.getVenueIncome();
    }

    @Override
    public String payMoney(String venueName, String money) {
        String count = "";

        int success = statisticsDao.payMoney(venueName,money);

        if(success<0){
            count="结算失败！";
        }else{
            count="结算成功！";
        }
        return count;
    }


}
