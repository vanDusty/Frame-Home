package cn.van.desensitization.demo.util;


import org.apache.commons.lang3.StringUtils;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: DesensitizedUtil
 *
 * @author: Van
 * Date:     2020-08-02 20:20
 * Description: 脱敏工具类
 * Version： V1.0
 */
public class DesensitizedUtil {

    /**
     * 【脱敏左方，保留右方指定位数字符】比如：风尘**
     *
     * @param str   待处理字段
     * @param index 不脱敏位数
     * @return
     */
    public static String desensitizedFrontField(String str, int index) {
        return append(str, index, true);
    }

    /**
     * 【脱敏左方，保留右方指定位数字符】比如：**博客
     *
     * @param str   待处理字段
     * @param index 不脱敏位数
     * @return
     */
    public static String desensitizedBehindField(String str, int index) {
        return append(str, index, true);
    }

    /**
     * 【脱敏中间，保留左方右方指定位数字符】比如：风**客
     *
     * @param str    待处理字段
     * @param begNum 左方不脱敏位数
     * @param endNum 右方不脱敏位数
     * @return
     */
    public static String desensitizedMiddleField(String str, int begNum, int endNum) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        // 脱敏位数超过原字符串长度，无法脱敏
        if ((begNum + endNum) >= str.length()) {
            return str;
        }
        String begStr = str.substring(0, begNum);
        String midStr = str.substring(begNum, str.length() - begNum);
        String endStr = str.substring(str.length() - endNum);
        StringBuffer sb = new StringBuffer(begStr);
        for (int i = 0; i < midStr.length(); i++) {
            sb.append("*");
        }
        return sb.append(endStr).toString();
    }

    /**
     * 【电子邮箱 邮箱前缀仅显示第一个字符，@及后面的地址显示】 比如：d**@126.com
     *
     * @param email
     * @return
     */
    public static String desensitizedMail(String email) {
        if (StringUtils.isEmpty(email)) {
            return "";
        }
        String[] str = email.split("@");
        String begStr = str[0];
        String endStr = str[1];
        begStr = append(begStr, 1, false);
        return begStr.concat("@").concat(endStr);
    }

    /**
     * 【密码 全部字符都用*代替】比如：******
     *
     * @param password
     * @return
     */
    public static String desensitizedPassword(String password) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < password.length(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    private static String append(String str, int index, boolean front) {
        if (StringUtils.isEmpty(str) || index > str.length()) {
            return "";
        }
        if (index == str.length()) {
            return str;
        }
        String begStr = str.substring(0, index);
        String endStr = str.substring(index);
        StringBuffer sb = new StringBuffer();
        if (front) {
            for (int i = 0; i < begStr.length(); i++) {
                sb.append("*");
            }
            sb.append(endStr);
        } else {
            sb.append(begStr);
            for (int i = 0; i < endStr.length(); i++) {
                sb.append("*");
            }
        }
        return sb.toString();
    }
}
