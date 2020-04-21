package cn.van.spring.copy.mapstruct;

import cn.van.spring.copy.mapstruct.convert.UserConvertUtils;
import cn.van.spring.copy.mapstruct.domain.UserDO;
import cn.van.spring.copy.mapstruct.domain.UserDTO;
import cn.van.spring.copy.mapstruct.domain.UserInfoDO;
import cn.van.spring.copy.mapstruct.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserConvertUtilsDemo
 *
 * @author: Van
 * Date:     2019-11-08 18:05
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Slf4j
public class MapStructTest {
    /**
     * 一般拷贝
     */
    @Test
    public void normalCopy() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        UserDTO userDTO = UserConvertUtils.INSTANCE.doToDTO(userDO);
        log.info("拷贝后：userDTO:{}", userDTO);
    }
    /**
     * 包含类型转换的拷贝
     */
    @Test
    public void doToDtoWithConvert() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        UserDTO userDTO = UserConvertUtils.INSTANCE.doToDtoWithConvert(userDO);
        log.info("拷贝后：userDTO:{}", userDTO);
    }
    /**
     * 包含类型转换的拷贝
     */
    @Test
    public void doAndInfoToDto() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        UserDTO userDTO = UserConvertUtils.INSTANCE.doAndInfoToDto(userDO, new UserInfoDO(1));
        log.info("拷贝后：userDTO:{}", userDTO);
    }


}
