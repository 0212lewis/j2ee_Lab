package cn.edu.nju.p.dao.impl;

import cn.edu.nju.p.dao.StatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by pc on 2018/3/12.
 */
@Repository
public class StatisticsDaoImpl implements StatisticsDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;


}
