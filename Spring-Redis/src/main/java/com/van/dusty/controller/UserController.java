package com.van.dusty.controller;

import com.van.dusty.common.result.ApiResult;
import com.van.dusty.service.UserService;
import com.van.dusty.service.entity.MobileRegisterParamVO;
import com.van.dusty.service.entity.SmsCodeParamVO;
import com.van.dusty.service.entity.UserVO;
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

    @RequestMapping("/register")
    public ModelAndView registerView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/RegisterView");
        return mv;
    }

    /**
     * 发送短信验证码
     * @param phone ：手机号
     * @param osType ：平台 ios/android/web
     * @param type ：请求类型 注册：register ；忘记密码：find
     * @return
     */
    @RequestMapping(value = "/sendVerifyCode",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult sendVerifyCode(String phone,String osType,String type,String projectName) {
        SmsCodeParamVO smsCodeParamVO = new SmsCodeParamVO();
        smsCodeParamVO.setOsType(osType);
        smsCodeParamVO.setPhone(phone);
        smsCodeParamVO.setType(type);
        smsCodeParamVO.setZoneNum(86);
        smsCodeParamVO.setProjectName(projectName);
        ApiResult result = userService.sendSmsVerifyCode(smsCodeParamVO);
        return result;
    }



    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult toRegister(MobileRegisterParamVO mobileRegisterParamVO) {
        ApiResult result = userService.userRegister(mobileRegisterParamVO);
        return result;
    }


    @RequestMapping("/login")
    public ModelAndView loginView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/loginView");
        return mv;
    }
    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult toLogin(UserVO userVO) {
        ApiResult result = userService.userLogin(userVO);
        return result;
    }
}
