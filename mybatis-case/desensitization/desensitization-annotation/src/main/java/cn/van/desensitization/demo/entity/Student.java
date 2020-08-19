package cn.van.desensitization.demo.entity;

import cn.van.desensitization.demo.annotion.Desensitized;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Student {
    String name;
    Date born;
    double score;
    private boolean exists;
    private Timestamp startTime;
    @Desensitized(type = SensitiveTypeEnum.CHINESE_NAME)
    private String chinaName;
    @Desensitized(type = SensitiveTypeEnum.MOBILE_PHONE)
    private String moble_phone;
//    @Desensitized(type = SensitiveTypeEnum.CARNUMBER)
    private String carNumber;
}
