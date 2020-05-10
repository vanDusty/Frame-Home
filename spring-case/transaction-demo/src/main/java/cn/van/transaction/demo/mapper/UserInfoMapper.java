package cn.van.transaction.demo.mapper;

import cn.van.transaction.demo.entity.UserInfoDO;

public interface UserInfoMapper {

    int deleteUser(Long userId);

    int deleteUserInfo(Long userId);
}