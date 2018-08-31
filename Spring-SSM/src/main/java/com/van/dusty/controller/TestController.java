package com.van.dusty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: Spring-Home
 * @description: SSM+Velocity测试控制器
 * @author: Van
 * @create: 2018-08-31 18:32
 **/
@Controller
@RequestMapping("")
public class TestController {

    @RequestMapping("/sayHello")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/sayHello");
        return mv;
    }


}
