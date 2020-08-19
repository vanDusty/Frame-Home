package cn.van.desensitization.demo.mapper;

import cn.van.desensitization.demo.entity.UserInfoDO;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfoDO record);

    int insertSelective(UserInfoDO record);

    UserInfoDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfoDO record);

    int updateByPrimaryKey(UserInfoDO record);
}