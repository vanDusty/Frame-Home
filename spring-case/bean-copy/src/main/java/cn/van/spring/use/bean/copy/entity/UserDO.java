package cn.van.spring.use.bean.copy.entity;

import lombok.Data;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserDO
 *
 * @author: Van
 * Date:     2020-01-01 11:06
 * Description: 表的映射模型
 * Version： V1.0
 */
@Data
public class UserDO {

    private Long userId;
    private String userName;
    private Integer age;
    private Integer sex;
    public UserDO() {

    }

    public UserDO(Long userId, String userName, Integer age, Integer sex) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }
}
