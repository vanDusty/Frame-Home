package cn.van.transaction.demo;

import cn.van.transaction.demo.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: TransactionDemoTest
 *
 * @author: Van
 * Date:     2020-02-02 15:49
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionDemoTest {

    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    TransactionTemplate transactionTemplate;

    /**
     * 不加事务
     */
    @Test
    public void delUserWithoutTransaction() {
        userInfoMapper.deleteUser(1L);
        if (true) {
            throw new RuntimeException("自造一个异常");
        }
        userInfoMapper.deleteUserInfo(1L);
    }

    /**
     * 注解方式
     */
    @Test
    @Transactional
    public void delUserWithAnnotationTransaction() {
        userInfoMapper.deleteUser(2L);
        if (true) {
            throw new RuntimeException("自造一个异常");
        }
        userInfoMapper.deleteUserInfo(2L);
    }

    @Test
    public void delUserWithTransaction() {
        boolean executeRet = transactionTemplate.execute(transactionStatus -> {
            userInfoMapper.deleteUser(1L);
            if (true) {
                transactionStatus.setRollbackOnly();
                throw new RuntimeException("自造一个异常");
            }
            userInfoMapper.deleteUserInfo(1L);
            return true;
        });
    }

}
