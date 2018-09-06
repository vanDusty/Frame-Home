package com.van.dusty.service;

import com.van.dusty.common.result.ApiResult;
import com.van.dusty.model.UserDO;
import com.van.dusty.service.entity.SendSmsCodeVO;

public interface UserService {

    ApiResult sendSmsVerifyCode(SendSmsCodeVO sendSmsCodeVO);

    ApiResult checkSmsVerifyCode(String phone,String verifyCode);

    ApiResult userLogin(UserDO userDO);

}
