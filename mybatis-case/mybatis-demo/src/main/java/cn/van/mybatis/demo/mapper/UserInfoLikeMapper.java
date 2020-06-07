package cn.van.mybatis.demo.mapper;

import cn.van.mybatis.demo.entity.UserInfoLikeDO;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserInfoLikeMapper
 *
 * @author: Van
 * Date:     2019-06-02 15:10
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
public interface UserInfoLikeMapper {

    List<UserInfoLikeDO> selectByKeyWord(String nickName);

    List<UserInfoLikeDO> selectByWord(String nickName);

    List<UserInfoLikeDO> selectForConcat(String nickName);

    List<UserInfoLikeDO> selectForBind(String nickName);


}
