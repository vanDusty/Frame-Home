package com.van.dusty.service.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @program: Spring-Home
 * @description: 短信验证码实体
 * @author: Van
 * @create: 2018-09-10 14:58
 **/
public class SmsCodeParamVO implements Serializable {

    private String verifyCode; //验证码

    private String phone;//手机号码

    private Integer zoneNum; //国际区号

    private String type; //验证码类型。注册验证码：register ；忘记密码验证：find

    public String projectName;// 项目名称

    private String pictureCode;//图片验证码

    private String osType; //登录平台：ios/android/web

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getZoneNum() {
        return zoneNum;
    }

    public void setZoneNum(Integer zoneNum) {
        this.zoneNum = zoneNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPictureCode() {
        return pictureCode;
    }

    public void setPictureCode(String pictureCode) {
        this.pictureCode = pictureCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
