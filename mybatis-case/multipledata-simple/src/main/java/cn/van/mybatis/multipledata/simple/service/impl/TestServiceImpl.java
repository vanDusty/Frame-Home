package cn.van.mybatis.multipledata.simple.service.impl;


import cn.van.mybatis.multipledata.simple.entity.UserInfo;
import cn.van.mybatis.multipledata.simple.mapper.master.User1Mapper;
import cn.van.mybatis.multipledata.simple.mapper.slave.User2Mapper;
import cn.van.mybatis.multipledata.simple.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: TestServiceImpl
 * @author: Van
 * Date:     2019-03-26 15:10
 * Description: 测试接口
 * Version： V1.0
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    User1Mapper user1Mapper;
    @Resource
    User2Mapper user2Mapper;

    public void insertMater(UserInfo userInfo) {
        user1Mapper.insert(userInfo);
    }

    public void insertSlave(UserInfo userInfo) {
        user2Mapper.insert(userInfo);
    }
}