package cn.van.desensitization.demo.entity;

import cn.van.desensitization.demo.desensitization.Desensitized;
import cn.van.desensitization.demo.desensitization.SensitiveTypeEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserInfoDO implements Serializable {
    private Long id;

    private String userName;

    @Desensitized(type = SensitiveTypeEnum.PASSWORD)
    private String passWord;

    private String nickName;

    @Desensitized(type = SensitiveTypeEnum.TEL_PHONE)
    private String telNumber;

    @Desensitized(type = SensitiveTypeEnum.MOBILE_PHONE)
    private String mobile;

    @Desensitized(type = SensitiveTypeEnum.EMAIL)
    private String email;

    @Desensitized(type = SensitiveTypeEnum.BANK_CARD)
    private String bankCard;

    @Desensitized(type = SensitiveTypeEnum.CAR_NUMBER)
    private String carNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;

}