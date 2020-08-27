package cn.van.desensitization.demo.desensitization;

import cn.van.desensitization.demo.util.DesensitizedUtil;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: DesensitizedFormatter
 *
 * @author: Van
 * Date:     2020-08-02 20:45
 * Description: 按需求格式化（脱敏）数据
 * Version： V1.0
 */
public class DesensitizedFormatter implements Formatter<String> {

    private SensitiveTypeEnum sensitiveTypeEnum;

    public SensitiveTypeEnum getSensitiveTypeEnum() {
        return sensitiveTypeEnum;
    }

    public void setSensitiveTypeEnum(SensitiveTypeEnum sensitiveTypeEnum) {
        this.sensitiveTypeEnum = sensitiveTypeEnum;
    }

    @Override
    public String parse(String valueStr, Locale locale) throws ParseException {
        if (!StringUtils.isEmpty(valueStr)) {
            switch (sensitiveTypeEnum) {
                case CHINESE_NAME:
                    String firstName = valueStr.substring(1);
                    valueStr = firstName.concat("**");
                    break;
                case ID_CARD:
                    valueStr = DesensitizedUtil.desensitizedFrontField(valueStr,  4);
                    break;
                case TEL_PHONE:
                    valueStr = DesensitizedUtil.desensitizedFrontField(valueStr, 4);
                    break;
                case MOBILE_PHONE:
                    valueStr = DesensitizedUtil.desensitizedMiddleField(valueStr, 3, 4);
                    break;
                case EMAIL:
                    valueStr = DesensitizedUtil.desensitizedMail(valueStr);
                    break;
                case BANK_CARD:
                    valueStr = DesensitizedUtil.desensitizedMiddleField(valueStr, 6, 4);
                    break;
                case PASSWORD:
                    valueStr = DesensitizedUtil.desensitizedPassword(valueStr);
                    break;
                case CAR_NUMBER:
                    valueStr = DesensitizedUtil.desensitizedMiddleField(valueStr, 2, 1);
                    break;
                case ADDRESS:
                    valueStr = DesensitizedUtil.desensitizedBehindField(valueStr, 8);
                    break;
                default:
            }
        }
        return valueStr;
    }

    @Override
    public String print(String s, Locale locale) {
        return s;
    }
}
