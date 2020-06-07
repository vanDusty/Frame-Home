package cn.van.mybatis.pagehelper.mapper;

import cn.van.mybatis.pagehelper.entity.UserInfoPagehelperDO;

import java.util.List;

public interface UserInfoPagehelperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfoPagehelperDO record);

    int insertSelective(UserInfoPagehelperDO record);

    UserInfoPagehelperDO selectByPrimaryKey(Long id);

    List<UserInfoPagehelperDO> selectList();

    int updateByPrimaryKeySelective(UserInfoPagehelperDO record);

    int updateByPrimaryKey(UserInfoPagehelperDO record);
}