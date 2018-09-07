package com.van.dusty.service;


import com.van.dusty.common.result.ApiResult;
import com.van.dusty.model.UserDO;
import com.van.dusty.model.UserInfoDO;

public interface UserService {

    ApiResult userLogin(UserDO userDO);

    ApiResult userRegister(UserInfoDO userInfoDO);

}
