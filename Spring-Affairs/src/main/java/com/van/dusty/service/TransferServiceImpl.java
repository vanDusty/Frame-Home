package com.van.dusty.service;

import com.van.dusty.dao.TransferDao;

import javax.annotation.Resource;

/** 未进行事务管理的转账示例
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-08-24 00:12
 **/
public class TransferServiceImpl implements TransferService {
    @Resource
    TransferDao transferDao;

    public void transferForOther(Integer inId, Integer outId, Integer number) {
        //先扣除转出账户的钱
        transferDao.delMoney(outId,number);
        // int num = 1/0; // 故意设置的转账异常
        //再增加转入账户的钱
        transferDao.addMoney(inId,number);
    }
}
