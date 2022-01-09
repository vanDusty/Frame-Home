package cn.van.mybatis.demo.util;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2022/1/6 11:54 下午
 * Description: AES 加密工具类
 * Version： V1.0
 */
public class AesUtil {

    /**
     * 加密
     * @param sSrc
     * @param sKey
     * @return
     */
    public static String Encrypt(String sSrc, String sKey) {
        byte[] encrypted;
        try {
            if (sKey == null) {
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * 解密
     * @param sSrc
     * @param sKey
     * @return
     */
    public static String Decrypt(String sSrc, String sKey) {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            //先用base64解密
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "fdj!s#la$krdF3DG";
        // 需要加密的字串
        String cSrc = "17000000000";
        System.out.println(cSrc);
        // 加密
        String enString = AesUtil.Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = AesUtil.Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);
    }
}