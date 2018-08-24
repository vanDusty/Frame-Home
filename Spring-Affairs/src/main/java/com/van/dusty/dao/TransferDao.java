package com.van.dusty.dao;

/**
 * @program: Spring-Home
 * @description: 转账案例Dao接口实现类
 * @author: Van
 * @create: 2018-08-24 00:16
 **/
public interface TransferDao {

    public void addMoney(Integer userId, Integer number);

    public void delMoney(Integer userId, Integer number);
}
