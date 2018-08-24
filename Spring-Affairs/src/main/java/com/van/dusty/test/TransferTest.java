package com.van.dusty.test;

import com.van.dusty.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/** 未加事务管理的转账案例的测视类
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-08-23 18:39
 **/
@RunWith(SpringJUnit4ClassRunner.class) //让测试在Spring容器环境下执行
@ContextConfiguration("classpath:applicationContent.xml") //加载核心配置文件
public class TransferTest {

    @Resource
    TransferService transferService;
    // 测试转账操作
    @Test
    public void test() {
        transferService.transferForOther(1,2,100);
    }
}
