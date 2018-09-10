package com.van.dusty.controller;

import com.van.dusty.common.result.ApiResult;
import com.van.dusty.service.UserService;
import com.van.dusty.service.entity.SendSmsCodeVO;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @program: Spring-Home
 * @description: SSM+Velocity测试控制器
 * @author: Van
 * @create: 2018-08-31 18:32
 **/
@Controller
@RequestMapping("")
public class TestController {
    @Resource
    UserService userService;

    @RequestMapping("/sayHello")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/sayHello");
        return mv;
    }

    @RequestMapping("/test")
    public ApiResult testRedis() {
        String phone = "13100000001";
        SendSmsCodeVO sendSmsCodeVO = new SendSmsCodeVO();
        ApiResult result = userService.sendSmsVerifyCode(sendSmsCodeVO);
        String verifyCode = (String) result.getData();
        System.err.println(verifyCode);
        return result;
    }
    @RequestMapping("/check")
    public ApiResult checkVerifyCode() {
        String phone = "13100000001";
//        String verifyCode = "123";
//        ApiResult result = userService.checkSmsVerifyCode(phone,verifyCode);
        return null;
    }


}
