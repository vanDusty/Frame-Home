package cn.van.mybatis.demo;

import cn.van.mybatis.demo.entity.Encrypt;
import cn.van.mybatis.demo.entity.UserInfoDO;
import cn.van.mybatis.demo.mapper.UserInfoMapper;
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

    @Test
    public void testEncrypt() {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserName("test");
        userInfoDO.setNickName("nickname");
        userInfoDO.setEmail("mail");
        userInfoDO.setMobile("12580");
        // 插入的是未加密的密码：van123
        userInfoDO.setPassWord(new Encrypt("van123"));
        userInfoMapper.insert(userInfoDO);
        // 插入到数据库，取出的密码
        log.info("password:{}", userInfoDO.getPassWord().getValue());
    }

}