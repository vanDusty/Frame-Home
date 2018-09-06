package com.van.dusty.common.result;

import com.van.dusty.common.exception.ApiResultException;

import java.io.Serializable;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-04 14:44
 **/
public class ApiResult implements Serializable {

    private static final long serialVersionUID = -7286421198462983370L;
    private boolean isSuccess = true;
    private Object data;
    private String error;
    private int code = 200;

    public ApiResult() {
    }

    public ApiResult(Object data) {
        this.data = data;
    }

    public ApiResult(int code, String error) {
        this.error = error;
        this.code = code;
        this.isSuccess = false;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.isSuccess = false;
        this.error = error;
    }

    public void setError(BaseResultCode result) {
        this.isSuccess = false;
        this.code = result.getCode();
        this.error = result.getMessage();
    }

    public void setError(int code, String errorMsg) {
        this.error = errorMsg;
        this.code = code;
        this.isSuccess = false;
    }

    public void setError(int code, String format, String errorMsg) {
        this.error = String.format(format, errorMsg);
        this.code = code;
        this.isSuccess = false;
    }

    public ApiResult check() throws ApiResultException {
        if (!this.isSuccess) {
            throw new ApiResultException(this.code, this.error);
        } else {
            return this;
        }
    }

}
