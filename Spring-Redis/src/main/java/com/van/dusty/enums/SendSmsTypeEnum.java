package com.van.dusty.enums;

import com.van.dusty.common.utils.StringUtils;

/**
 * 短信验证码类型枚举
 */
public enum SendSmsTypeEnum {
    REGISTER("register"), //注册
    QUICK_LOGIN("quickLogin"), //快速登录
    QUICK_REGISTER("quickRegister"), //快速注册
    FIND("find"), //找回密码

    ;

    private String message;

    public static SendSmsTypeEnum checkSendType(String type){
        if(StringUtils.isBlank(type)){
            return null;
        }
        for(SendSmsTypeEnum sendSmsTypeEnum : values()){
            if(sendSmsTypeEnum.getMessage().equals(type)){
                return sendSmsTypeEnum;
            }
        }
        return null;
    }

    SendSmsTypeEnum(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
