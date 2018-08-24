package com.van.dusty.service.demo1;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.van.dusty.dao.TransferDao;

import javax.annotation.Resource;

/** Spring声明式事务管理：基于Aspectj的XML方式的配置，无需对业务层代码进行修改
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-08-24 00:12
 **/
public class TransferServiceImpl_demo1 implements TransferService_demo1 {
    @Resource
    TransferDao transferDao;

    public void transferForOther(Integer inId, Integer outId, Integer number) {
        //先扣除转出账户的钱
        transferDao.delMoney(outId,number);
        insert();
         int num = 1/0; // 设置的转账异常
        //再增加转入账户的钱
        transferDao.addMoney(inId,number);
    }

    public void insert(){
        transferDao.addMoney(3,100);
    }

}
