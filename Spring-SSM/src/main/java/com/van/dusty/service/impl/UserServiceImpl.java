package com.van.dusty.service.impl;


import com.van.dusty.common.enums.ResultCode;
import com.van.dusty.common.result.ApiResult;
import com.van.dusty.common.result.ResultUtils;
import com.van.dusty.dao.UserDAO;
import com.van.dusty.model.UserDO;
import com.van.dusty.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;//这里会报错，但是并不会影响


    @Override
    public ApiResult userLogin(UserDO userDO) {
        UserDO user = userDAO.selectUserByUserName(userDO.getUserName());
        if (null == user) {
            return ResultUtils.setError(ResultCode.LACK_PARAM_ERROR);
        }
        if (!user.getPassword().equals(userDO.getPassword())) {
            return ResultUtils.setError(ResultCode.SYSTEM_ERROR);
        }
        return ResultUtils.setOk(user);
    }
}
