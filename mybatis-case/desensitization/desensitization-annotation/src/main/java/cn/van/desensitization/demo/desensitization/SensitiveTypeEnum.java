package cn.van.desensitization.demo.desensitization;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: SensitiveTypeEnum
 *
 * @author: Van
 * Date:     2020-08-02 20:45
 * Description: 定义脱敏类型枚举
 * Version： V1.0
 */
public enum SensitiveTypeEnum {
    /**
     * 中文姓名
     * 【只显示第一个汉字，其他隐藏为2个星号，比如：李**】
     */
    CHINESE_NAME,
    /**
     * 身份证号
     * 【显示最后四位，其他隐藏。共计18位或者15位，比如：*************1234】
     */
    ID_CARD,
    /**
     * 固定电话
     * 【显示后四位，其他隐藏，比如：*******3241】
     */
    TEL_PHONE,
    /**
     * 手机号码
     * 【前三位，后四位，其他隐藏，比如：135****6810】
     */
    MOBILE_PHONE,
    /**
     * 电子邮件
     * 【邮箱前缀仅显示第一个字母，前缀其他隐藏，用星号代替，@及后面的地址显示，比如：d**@126.com】
     */
    EMAIL,
    /**
     * 银行卡
     * 【前六位，后四位，其他用星号隐藏每位1个星号，比如：6222600**********1234】
     */
    BANK_CARD,
    /**
     * 密码
     * 【密码的全部字符都用代替，比如：*】
     */
    PASSWORD,
    /**
     * 车牌号
     * 【前两位，后一位，比如：浙A****9】
     */
    CAR_NUMBER,



    /**
     * 地址
     * 【只显示到地区，不显示详细地址，比如：上海徐汇区漕河泾开发区***】
     */
    ADDRESS,


    ;
}
