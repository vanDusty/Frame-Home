package cn.van.mybatis.druid.mapper;

import cn.van.mybatis.druid.entity.UserInfoDruidDO;

import java.util.List;

public interface UserInfoDruidMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfoDruidDO record);

    int insertSelective(UserInfoDruidDO record);

    List<UserInfoDruidDO> selectAll();

    UserInfoDruidDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfoDruidDO record);

    int updateByPrimaryKey(UserInfoDruidDO record);
}