package com.van.dusty.controller;

import com.van.dusty.common.result.ApiResult;
import com.van.dusty.model.UserDO;
import com.van.dusty.model.UserInfoDO;
import com.van.dusty.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @program: Spring-Home
 * @description: 登录控制器
 * @author: Van
 * @create: 2018-09-04 18:31
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView loginView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/LoginView");
        return mv;
    }
    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult toLogin(UserDO userDO) {
        ApiResult result = userService.userLogin(userDO);
        return result;
    }

    @RequestMapping("/register")
    public ModelAndView registerView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/registerView");
        return mv;
    }

    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult toRegister(UserInfoDO userInfoDO) {
        ApiResult result = userService.userRegister(userInfoDO);
        return result;
    }


}
