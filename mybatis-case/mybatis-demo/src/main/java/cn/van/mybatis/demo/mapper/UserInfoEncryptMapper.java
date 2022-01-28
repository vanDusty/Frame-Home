package cn.van.mybatis.demo.mapper;

import cn.van.mybatis.demo.entity.UserInfoEncryptDO;

public interface UserInfoEncryptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfoEncryptDO record);

    int insertSelective(UserInfoEncryptDO record);

    UserInfoEncryptDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfoEncryptDO record);

    int updateByPrimaryKey(UserInfoEncryptDO record);
}