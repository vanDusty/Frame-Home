package cn.van.mybatis.plus.common;

import cn.van.mybatis.plus.common.entity.MetaFillDO;
import cn.van.mybatis.plus.common.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2022/1/6 11:49 下午
 * Description: 自动填充字段测试
 * Version： V1.0
 */
@Slf4j
public class MetaFillTest extends BaseTest {

    @Resource
    private UserInfoMapper userInfoMapper;


    @Test
    public void metaFill() {
        MetaFillDO metaFillDO = new MetaFillDO();
        userInfoMapper.insert(metaFillDO);
    }
}
