package com.van.dusty.service.impl;


import com.van.dusty.common.enums.ResultCode;
import com.van.dusty.common.result.ApiResult;
import com.van.dusty.common.result.ResultUtils;
import com.van.dusty.dao.UserDAO;
import com.van.dusty.dao.UserIdListDAO;
import com.van.dusty.dao.UserInfoDAO;
import com.van.dusty.model.UserDO;
import com.van.dusty.model.UserIdListDO;
import com.van.dusty.model.UserInfoDO;
import com.van.dusty.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Resource
    private UserIdListDAO userIdListDAO;
    @Resource
    private UserInfoDAO userInfoDAO;

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

    @Override
    public ApiResult userRegister(UserInfoDO userInfoDO) {

        // 生成ID
        Long userId = createUserId();
        // 插入用户详情

        createUserInfo(userInfoDO, userId);
        return ResultUtils.setOk(userId);
    }

    private Long createUserId() {
        UserIdListDO userIdListDO = new UserIdListDO(1);
        userIdListDAO.insert(userIdListDO);
        return userIdListDO.getId();
    }

    private void createUserInfo(UserInfoDO userInfoDO,Long userId) {
        userInfoDO.setUserId(userId);
        userInfoDAO.insertSelective(userInfoDO);
    }

}
