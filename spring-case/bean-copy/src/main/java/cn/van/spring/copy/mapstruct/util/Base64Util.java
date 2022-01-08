package cn.van.spring.copy.mapstruct.util;

import sun.misc.BASE64Encoder;
/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: Base64Util
 *
 * @author: Van
 * Date:     2019-11-02 18:32
 * Description: 加密工具类
 * Version： V1.0
 */
public class Base64Util {

    public static String encode(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(str.getBytes());
        return encode;
    }
}