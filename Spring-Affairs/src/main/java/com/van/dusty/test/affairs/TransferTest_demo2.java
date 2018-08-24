package com.van.dusty.test.affairs;

import com.van.dusty.service.demo1.TransferService_demo1;
import com.van.dusty.service.demo2.TransferService_demo2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/** Spring声明式事务管理：基于注解
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-08-23 01:39
 **/
@RunWith(SpringJUnit4ClassRunner.class) //让测试在Spring容器环境下执行
@ContextConfiguration("classpath:applicationContent-demo2.xml") //加载核心配置文件
public class TransferTest_demo2 {

    @Resource
    TransferService_demo2 transferService;
    // 测试转账操作
    @Test
    public void test() {
        transferService.transferForOther(1,2,300);
    }
}
