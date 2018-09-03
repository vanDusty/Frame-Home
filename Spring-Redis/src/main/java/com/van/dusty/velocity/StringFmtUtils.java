package com.van.dusty.velocity;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 13:46
 **/
public class StringFmtUtils {
    public static String fmtValue(String userName){
        if(StringUtils.isEmpty(userName)){
            return "";
        }
        if(userName.length()<2){
            return userName;
        }else if(userName.length()==3){
            return userName.substring(0,1)+"*"+ userName.substring(2,3);
        }else {
            return  userName.substring(0,1)+"**"+userName.substring(userName.length()-1,userName.length());
        }
    }

    public static  String fmtMobile(String mobile){
        if(StringUtils.isEmpty(mobile)){
            return "";
        }
        if(mobile.length()>7){
            return mobile.substring(0,3)+"***"+mobile.substring(mobile.length()-4,mobile.length());
        }else{
            return mobile;
        }
    }
    public static String fmtSimpleValue(String content){
        if(StringUtils.isEmpty(content)){
            return "";
        }
        if(content.length()>70){
            return content.substring(0,70);
        }
        return content;
    }
    public static String fmtDetailValue(String content){
        if(StringUtils.isEmpty(content)){
            return "";
        }
        if(content.length()>70){
            return content.substring(70);
        }
        return "";
    }
}
