package com.van.dusty.service;


import com.van.dusty.common.result.ApiResult;
import com.van.dusty.model.UserDO;

public interface UserService {

    ApiResult userLogin(UserDO userDO);

}
