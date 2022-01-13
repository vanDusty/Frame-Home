package cn.van.mybatis.pagination.mapper;

import cn.van.mybatis.pagination.entity.UserInfoDO;

import java.util.List;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserMapper
 *
 * @author: Van
 * Date:     2019-06-24 15:52
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
public interface UserMapper {

    List<UserInfoDO> findAll();

}