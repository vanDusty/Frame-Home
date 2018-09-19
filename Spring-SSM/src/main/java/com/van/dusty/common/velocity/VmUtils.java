package com.van.dusty.common.velocity;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 13:43
 **/
public class VmUtils {
    public static String selected(Object s1,Object s2){
        if (s1 != null && String.valueOf(s1).equals(String.valueOf(s2))) {
            return "selected";
        }
        return "";
    }
}
