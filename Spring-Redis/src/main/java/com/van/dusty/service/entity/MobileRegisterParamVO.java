package com.van.dusty.service.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @program: Spring-Home
 * @description: 手机号注册实体
 * @author: Van
 * @create: 2018-09-12 14:26
 **/
public class MobileRegisterParamVO implements Serializable {

    private String userName; //用户名称

    private String password; //密码

    private String nickName; //昵称

    private String phone; //手机号

    private String email; //邮箱

    private SmsCodeParamVO param; // 验证码相关参数

    public SmsCodeParamVO getParam() {
        return param;
    }

    public void setParam(SmsCodeParamVO param) {
        this.param = param;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
