package com.van.dusty.velocity;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 13:45
 **/
public class XwUtils {
    public static String substring(String s, int len, String ss) {
        if (s != null && s.length() > len) {
            return s.substring(0, len) + ss;
        } else {
            return s;
        }
    }
}
