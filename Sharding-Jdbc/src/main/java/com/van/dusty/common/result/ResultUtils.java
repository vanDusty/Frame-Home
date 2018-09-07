package com.van.dusty.common.result;

import com.alibaba.fastjson.JSONObject;
import com.van.dusty.common.enums.ResultCode;
import com.van.dusty.common.utils.Underline2CamelUtil;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-04 14:49
 **/
public class ResultUtils {
    public static ApiResult setError(ResultCode resultCode) {
        return setError(null,resultCode);
    }

    public static ApiResult setError(ApiResult apiResult, ResultCode resultCode) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setError(resultCode.getMessage());
        apiResult.setCode(resultCode.getCode());
        apiResult.setSuccess(false);

        return apiResult;
    }

    public static ApiResult setError(int code, String message) {

        ApiResult apiResult = new ApiResult();
        apiResult.setError(message);
        apiResult.setCode(code);
        apiResult.setSuccess(false);

        return apiResult;
    }

    public static ApiResult setError(ResultCode resultCode,String message) {
        return setError(null,resultCode,message);
    }

    public static ApiResult setError(ApiResult apiResult,ResultCode resultCode,String message) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setError(String.format(resultCode.getMessage(),message));
        apiResult.setCode(resultCode.getCode());
        apiResult.setSuccess(false);

        return apiResult;
    }



    public static ApiResult setOk() {
        return setOk(null);
    }

    public static ApiResult setOk(ApiResult apiResult) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setData(null);
        apiResult.setSuccess(true);
        apiResult.setCode(ResultCode.SUCCESS.getCode());

        return apiResult;
    }

    public static ApiResult setOk(Object data) {
        return setOk(null, data);
    }

    public static ApiResult setOk(ApiResult apiResult,Object data) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setData(data);
        apiResult.setSuccess(true);
        apiResult.setCode(ResultCode.SUCCESS.getCode());

        return apiResult;
    }

    public static boolean isFailure(ApiResult apiResult) {
        return !apiResult.isSuccess();
    }

    /**
     * 把ApiResult转换成JSON格式，把code为0的转换成200
     * @param apiResult
     * @return
     */
    public static JSONObject setRestJsonDataSDK(ApiResult apiResult){
        if(apiResult.isSuccess()){
            if(ResultCode.SUCCESS.getCode() == apiResult.getCode()){
                apiResult.setCode(ResultCode.SUCCESS.getCode());
            }
        }
        return setRestJsonDataSDK(apiResult.getCode(), apiResult.getError(),apiResult.getData());
    }

    /**
     * 把ApiResult转换成JSON格式，把code为0的转换成200
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static JSONObject setRestJsonDataSDK(Integer code, String msg,Object  data){
        JSONObject json=new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        json.put("data",data);
        return  json;
    }



    /**
     * 把ApiResult转换成REST调用的下划线格式
     * @param apiResult
     * @return
     */
    public static JSONObject setRestJsonData(ApiResult apiResult){
        JSONObject json=new JSONObject();
        json.put("code", apiResult.getCode());
        json.put("msg", apiResult.getError());
    	/*if(apiResult.getData()!=null){
    		String className=apiResult.getData().getClass().getName();
    		if(className.contains("com.xwcloud.")){//对象属性转成下划线形式
    			json.put("data", Underline2CamelUtil.camel2UnderlineForObj(apiResult.getData()));
    			return  json;
    		}
    		if(className.equals("java.util.ArrayList")){
    			//TODO 集合暂时不处理
    		}
    	}*/
        json.put("data",apiResult.getData());
        return  json;
    }
    /**
     * 把ApiResult转换成REST调用的下划线格式
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static JSONObject setRestJsonData(Integer code, String msg, Object  data){
        JSONObject json=new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        if(data!=null){
            String className=data.getClass().getName();
            if(className.contains("com.xwcloud.")){//对象属性转成下划线形式
                json.put("data", Underline2CamelUtil.camel2UnderlineForObj(data));
                return  json;
            }
        }
        json.put("data",data);
        return  json;
    }

    public static ResultCode getResultCodeByName(String name){
        ResultCode resultCode = ResultCode.valueOf(name);
        return resultCode;
    }
}
