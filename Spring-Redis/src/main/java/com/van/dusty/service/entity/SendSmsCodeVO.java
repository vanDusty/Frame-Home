package com.van.dusty.service.entity;

import java.io.Serializable;

/**
 * @program: Spring-Home
 * @description: 短信验证码实体
 * @author: Van
 * @create: 2018-09-05 17:59
 **/
public class SendSmsCodeVO implements Serializable {

    public String projectName;// 项目名称

    private String osType; //登录平台：ios/android/web

    private SendSmsCodeParams param; //内部类，用于放验证码详细参数

    public class SendSmsCodeParams implements Serializable{

        private Integer zoneNum;//国际区号

        private String phone;//手机号码

        private String pictureCode;//图片验证码

        private String type; //验证码类型。注册验证码：register ；忘记密码验证：find

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
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public SendSmsCodeParams getParam() {
        return param;
    }

    public void setParam(SendSmsCodeParams param) {
        this.param = param;
    }
}
