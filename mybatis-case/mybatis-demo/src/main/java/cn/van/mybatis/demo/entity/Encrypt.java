package cn.van.mybatis.demo.entity;

/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2022/1/6 11:49 下午
 * Description: 加密解密标识
 * Version： V1.0
 */
public class Encrypt {
    private String value;

    public Encrypt() {
    }

    public Encrypt(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}