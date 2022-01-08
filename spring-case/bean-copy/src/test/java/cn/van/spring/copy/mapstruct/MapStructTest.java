package cn.van.spring.copy.mapstruct;

import cn.van.spring.copy.mapstruct.convert.MapstructConvert;
import cn.van.spring.copy.mapstruct.domain.UserInfoDTO;
import cn.van.spring.copy.mapstruct.entity.RoleDO;
import cn.van.spring.copy.mapstruct.entity.UserExtInfoDO;
import cn.van.spring.copy.mapstruct.entity.UserInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: MapStructTest
 *
 * @author: Van
 * Date:     2019-11-08 18:05
 * Description:
 * Version： V1.0
 */
@Slf4j
public class MapStructTest {

    private UserInfoDO userInfoDO;
    private UserInfoDO userInfoDO2;
    private List<UserInfoDO> userInfoDOS;
    private UserExtInfoDO userExtInfoDO;


    @Before
    public void genData() {
        // 模拟查询出数据
        RoleDO roleDO = new RoleDO(1L, "管理员", "admin");
        userInfoDO = new UserInfoDO(roleDO, 100L, "VanFan", "password", "12580",new Date());
        userInfoDO2 = new UserInfoDO(roleDO, 101L, "VanFan2", "password", "12580", null);
        userInfoDOS = Stream.of(userInfoDO,userInfoDO2).collect(Collectors.toList());
        userExtInfoDO = new UserExtInfoDO("写代码");
    }

    /**
     * 一对一映射
     */
    @Test
    public void doToDTO() {
        log.info("doToDTO 拷贝前：userInfoDO:{}", userInfoDO);
        UserInfoDTO userInfoDTO = MapstructConvert.INSTANCE.doToDTO(userInfoDO);
        log.info("doToDTO 拷贝后：userInfoDTO:{}", userInfoDTO);
    }

    /**
     * 集合映射(映射关系继承【一对一映射】)
     */
    @Test
    public void doSToDTOS() {

        log.info("doSToDTOS 拷贝前：userInfoDO:{}", userInfoDO);
        List<UserInfoDTO> userInfoDTOs = MapstructConvert.INSTANCE.doSToDTOS(userInfoDOS);
        log.info("doSToDTOS 拷贝后：userInfoDTO:{}", userInfoDTOs);
    }

    /**
     * 多参数映射
     */
    @Test
    public void doToDtoWithConvert() {
        log.info("拷贝前：doToDtoWithConvert:{}", userInfoDO);
        UserInfoDTO userInfoDTO = MapstructConvert.INSTANCE.doToDtoMulti(userInfoDO, userExtInfoDO);
        log.info("拷贝后：doToDtoWithConvert:{}", userInfoDTO);
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