package cn.van.spring.copy.mapstruct.convert;

import cn.van.spring.copy.mapstruct.domain.UserDO;
import cn.van.spring.copy.mapstruct.domain.UserDTO;
import cn.van.spring.copy.mapstruct.domain.UserInfoDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserConvertUtils
 *
 * @author: Van
 * Date:     2019-11-08 20:56
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Mapper
public interface UserConvertUtils {

    UserConvertUtils INSTANCE = Mappers.getMapper(UserConvertUtils.class);

    /**
     * 普通的映射
     *
     * @param userDO UserDO数据持久层类
     * @return 数据传输类
     */
    UserDTO doToDTO(UserDO userDO);

    /**
     * 类型转换的映射
     *
     * @param userDO UserDO数据持久层类
     * @return 数据传输类
     */
    @Mappings({
            @Mapping(target = "gmtBroth", source = "gmtBroth", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "balances", source = "balance"),
    })
    UserDTO doToDtoWithConvert(UserDO userDO);

    /**
     * 多对一映射
     * @param userDO
     * @param userInfoDO
     * @return
     */
    UserDTO doAndInfoToDto(UserDO userDO, UserInfoDO userInfoDO);
}
