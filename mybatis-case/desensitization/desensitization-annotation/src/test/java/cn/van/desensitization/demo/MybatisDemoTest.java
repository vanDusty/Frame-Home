package cn.van.desensitization.demo;

import cn.van.desensitization.demo.BaseTest;
import cn.van.desensitization.demo.entity.UserInfoDO;
import cn.van.desensitization.demo.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: MybatisLikeTest
 *
 * @author: Van
 * Date:     2020-02-02 15:49
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Slf4j
public class MybatisDemoTest extends BaseTest {

    @Resource
    UserInfoMapper userInfoMapper;

    @Test
    public void selectByPrimaryKey() {
        UserInfoDO userInfoDO = userInfoMapper.selectByPrimaryKey(1L);
        log.info("userInfoDO:{}", userInfoDO);
    }

}
