package com.van.dusty.service.demo2;

import com.van.dusty.dao.TransferDao;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-08-24 00:12
 **/
public class TransferServiceImpl_demo2 implements TransferService_demo2 {
    @Resource
    TransferDao transferDao;
    @Transactional
    public void transferForOther(Integer inId, Integer outId, Integer number) {
        //先扣除转出账户的钱
        transferDao.delMoney(outId,number);
        int num = 1/0; // 故意设置的转账异常
        //再增加转入账户的钱
        transferDao.addMoney(inId,number);
    }
}
