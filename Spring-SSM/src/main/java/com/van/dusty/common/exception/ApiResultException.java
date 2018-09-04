package com.van.dusty.common.exception;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-04 14:46
 **/
public class ApiResultException extends Exception{
    private String msg;
    private int code;

    public ApiResultException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
