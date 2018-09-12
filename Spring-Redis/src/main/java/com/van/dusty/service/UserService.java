package com.van.dusty.service;

import com.van.dusty.common.result.ApiResult;
import com.van.dusty.service.entity.MobileRegisterParamVO;
import com.van.dusty.service.entity.SmsCodeParamVO;
import com.van.dusty.service.entity.UserVO;

public interface UserService {

    public ApiResult sendSmsVerifyCode(SmsCodeParamVO smsCodeParamVO);

    public ApiResult userRegister(MobileRegisterParamVO param);

    public ApiResult userLogin(UserVO userVO);



}
