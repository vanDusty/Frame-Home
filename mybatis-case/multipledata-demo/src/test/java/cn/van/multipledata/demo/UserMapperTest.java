package cn.van.multipledata.demo;


import cn.van.multipledata.demo.entity.UserInfo;
import cn.van.multipledata.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserMapperTest
 *
 * @author: Van
 * Date:     2019-07-30 15:58
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class UserMapperTest {

    @Resource
    private UserService userService;

    /**
     * 测试主库 master
     */
    @Test
    public void selectMaster() {
        List<UserInfo> users = userService.selectMaster();
        log.info("master-users:{}", users);
    }

    /**
     * 测试从库 slave
     */
    @Test
    public void selectSlave() {
        List<UserInfo> users = userService.selectSlave();
        log.info("slave-users:{}", users);
    }

}
