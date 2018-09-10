package com.van.dusty.service;

import com.van.dusty.common.result.ApiResult;
import com.van.dusty.model.UserDO;
import com.van.dusty.service.entity.SendSmsCodeVO;

public interface UserService {

    ApiResult sendSmsVerifyCode(SendSmsCodeVO sendSmsCodeVO);

    ApiResult userRegister(UserDO userDO);

    ApiResult userLogin(UserDO userDO);

}
