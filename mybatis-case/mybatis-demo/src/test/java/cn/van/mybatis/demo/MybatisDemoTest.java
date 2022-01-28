package cn.van.mybatis.demo;

import cn.van.mybatis.demo.entity.Encrypt;
import cn.van.mybatis.demo.entity.UserInfoEncryptDO;
import cn.van.mybatis.demo.mapper.UserInfoEncryptMapper;
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
    UserInfoEncryptMapper userInfoEncryptMapper;

    @Test
    public void testEncrypt() {
        UserInfoEncryptDO userInfoEncryptDO = new UserInfoEncryptDO();
        userInfoEncryptDO.setUserName("test");
        userInfoEncryptDO.setNickName("nickname");
        userInfoEncryptDO.setEmail("mail");
        userInfoEncryptDO.setMobile("12580");
        // 插入的是未加密的密码：van123
        userInfoEncryptDO.setPassWord(new Encrypt("van123"));
        userInfoEncryptMapper.insert(userInfoEncryptDO);
        // 插入到数据库，取出的密码
        log.info("password:{}", userInfoEncryptDO.getPassWord().getValue());
    }

}