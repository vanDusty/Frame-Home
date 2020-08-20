package cn.van.desensitization.demo.annotion;

import cn.van.desensitization.demo.entity.SensitiveTypeEnum;
import cn.van.desensitization.demo.util.DesensitizedUtil;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;


public class DesensitizedFormatter implements Formatter<String> {
    private SensitiveTypeEnum typeEnum;

    public SensitiveTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(SensitiveTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    @Override
    public String parse(String valueStr, Locale locale) throws ParseException {
        if (!StringUtils.isEmpty(valueStr)) {
            switch (typeEnum) {
                case CHINESE_NAME:
                    valueStr = DesensitizedUtil.desensitizedBehindField(valueStr, 1);
                    break;
                case ID_CARD:
                    valueStr = DesensitizedUtil.desensitizedMiddleField(valueStr, 2, 4);
                    break;
                case FIXED_PHONE:
                    valueStr = DesensitizedUtil.desensitizedFrontField(valueStr, 4);
                    break;
                case MOBILE_PHONE:
                    valueStr = DesensitizedUtil.desensitizedMiddleField(valueStr, 3, 4);
                    break;
                case ADDRESS:
                    valueStr = DesensitizedUtil.desensitizedBehindField(valueStr, 8);
                    break;
                case EMAIL:
                    valueStr = DesensitizedUtil.desensitizedMail(valueStr);
                    break;
                case BANK_CARD:
                    valueStr = DesensitizedUtil.desensitizedMiddleField(valueStr, 2, 3);
                    break;
                case PASSWORD:
                    valueStr = DesensitizedUtil.desensitizedPassword(valueStr);
                    break;
                case CAR_NUMBER:
                    valueStr = DesensitizedUtil.desensitizedMiddleField(valueStr, 2, 1);
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
