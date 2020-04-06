package cn.van.spring.copy.beanutils.common;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: SexEnum
 *
 * @author: Van
 * Date:     2020-01-01 11:54
 * Description: 性别枚举
 * Version： V1.0
 */
public enum SexEnum {
    UNKNOW("未设置",0),
    MEN("男生", 1),
    WOMAN("女生",2),

    ;
    private String desc;
    private int code;

    SexEnum(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public static SexEnum getDescByCode(int code) {
        SexEnum[] typeEnums = values();
        for (SexEnum value : typeEnums) {
            if (code == value.getCode()) {
                return value;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
