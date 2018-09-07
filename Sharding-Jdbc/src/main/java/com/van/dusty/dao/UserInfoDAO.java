package com.van.dusty.dao;

import com.van.dusty.model.UserInfoDO;

public interface UserInfoDAO {

    int insert(UserInfoDO record);

    int insertSelective(UserInfoDO record);

}