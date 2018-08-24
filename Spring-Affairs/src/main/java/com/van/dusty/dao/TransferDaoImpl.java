package com.van.dusty.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @program: Spring-Home
 * @description: 转账案例Dao接口实现类
 * @author: Van
 * @create: 2018-08-24 00:16
 **/
public class TransferDaoImpl extends JdbcDaoSupport implements TransferDao {
    // 这里继承了spring-jdbc的模版类，便于Dao层操作数据库，还需要在Dao中注入连接池，详见配置
    /**
     * 转入
     * @param userId
     * @param number
     */
    public void addMoney(Integer userId, Integer number) {
        String sql = "UPDATE transfer SET user_account = user_account + ? WHERE id = ? ";
        this.getJdbcTemplate().update(sql, number, userId);
    }

    /**
     * 转出
     * @param userId
     * @param number
     */
    public void delMoney(Integer userId, Integer number) {
        String sql = "UPDATE transfer SET user_account =user_account - ? WHERE id = ? ";
        this.getJdbcTemplate().update(sql, number, userId);
    }
}
