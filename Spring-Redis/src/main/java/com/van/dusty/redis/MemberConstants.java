package com.van.dusty.redis;

import java.util.Map;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 18:59
 **/
public class MemberConstants {

    public static  final String VERIFY_CODE_FOR_BY_PHONE="phone_verify_code_"; //短信验证码

    public static final Integer FIFTEEN_MINUTES =15 * 60;//验证码有效时间

    public static final Integer ONE_MINUTES=60;//1分钟失效

    public static  final Integer MAX_SEND_COUNT=10; //发送短信验证码的最多次数

    public static  final String VERIFY_CODE_FOR_FREQUENT_ONE_MINUTE="verify_code_frequent_one_mimute_";//判断一分钟内不可重复发送的key

    public static  final String VERIFY_CODE_FOR_SEND_TIMES="verify_code_send_times_"; //短信验证码发送次数

    public static String putRediskey(String preKey,Object... params){ //将参数拼接为redis的key
        String sufKey="";
        for (Object param:params){
            sufKey=sufKey+"_"+param;
        }
        return preKey+sufKey;
    }
}
