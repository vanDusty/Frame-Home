package cn.van.mybatis.batch.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserInfoBatchDO implements Serializable {
    private Long id;

    private String userName;

    private String passWord;

    private String nickName;

    private String mobile;

    private String email;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;
}