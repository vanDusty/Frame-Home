package cn.van.spring.copy.mapstruct.util;

import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: Base64Util
 *
 * @author: Van
 * Date:     2019-11-02 18:32
 * Description: Base64 加密工具类
 * Version： V1.0
 */
public class Base64Util {

    public static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static byte[] decode(String str) {
        return Base64.getDecoder().decode(str);
    }
}