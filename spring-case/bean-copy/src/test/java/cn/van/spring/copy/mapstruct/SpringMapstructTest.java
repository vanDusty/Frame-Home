package cn.van.spring.copy.mapstruct;

import cn.van.spring.copy.mapstruct.convert.MapstructConvert;
import cn.van.spring.copy.mapstruct.convert.SpringMapstructConvert;
import cn.van.spring.copy.mapstruct.domain.UserInfoDTO;
import cn.van.spring.copy.mapstruct.entity.RoleDO;
import cn.van.spring.copy.mapstruct.entity.UserExtInfoDO;
import cn.van.spring.copy.mapstruct.entity.UserInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * Author:   Van
 * Date:     2022/1/8 11:56 下午
 * Description:
 * Version： V1.0
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringMapstructTest {

    private UserInfoDO userInfoDO;
    private UserExtInfoDO userExtInfoDO;

    @Resource
    private SpringMapstructConvert springMapstructConvert;

    @Before
    public void genData() {
        // 模拟查询出数据
        RoleDO roleDO = new RoleDO(1L, "管理员", "admin");
        userInfoDO = new UserInfoDO(roleDO, 100L, "VanFan", "password", "12580", new Date());        userExtInfoDO = new UserExtInfoDO("写代码");
        userExtInfoDO = new UserExtInfoDO("写代码");
    }

    @Test
    public void springMapstruct() {
        log.info("springMapstruct 拷贝前：userInfoDO:{}", userInfoDO);
        UserInfoDTO userInfoDTO = springMapstructConvert.doToDTO(userInfoDO);
        log.info("springMapstruct 拷贝后：userInfoDTO:{}", userInfoDTO);
    }

    /**
     * 映射到现有实例
     */
    @Test
    public void toAlready() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(102L);
        log.info("拷贝前：dtoToDTO:{}", userInfoDO);
        MapstructConvert.INSTANCE.toAlready(userInfoDTO, userExtInfoDO);
        log.info("拷贝后：dtoToDTO:{}", userInfoDTO);
    }
}