package com.van.dusty.common.enums;

import com.van.dusty.common.utils.StringUtils;

public enum ResultCode {
    /*通用部分*/
    SUCCESS(200, "successful"),//成功请求
    INTERNAL_ERROR(500, "internal error"),//未知异常，这个只有在异常没有捕获的时候才会出现
    INVOKE_EXCEPTION(100, "exception occur:%s"),//调用异常
    RESULT_IS_NULL(101, "result is null the id is:%s"),//返回结果为空
    SIGN_NOT_FOUND(186,"sign not found") ,//签名缺失



    /*** code 100000-200000 start*/
    PARAMS_ERROR(100001,"参数错误"),
    REPEAT_CALL(100002,"重复调用"),
    LACK_PARAM_ERROR(100003,"参数缺失"),
    SYSTEM_ERROR(100004, "系统错误"),
    ILLEGAL_PARAM(100005, "参数不合法"),
    ;


    private int code;
    private String message;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public static ResultCode valueOf(int code) {
        for (ResultCode value : values()) {
            if (code == value.code) {
                return value;
            }
        }

        return SUCCESS; // default is successful
    }

    public static boolean contains(String name){
        if (StringUtils.isBlank(name)) {
            return false;
        }
        for (ResultCode value : values()) {
            if (value.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
