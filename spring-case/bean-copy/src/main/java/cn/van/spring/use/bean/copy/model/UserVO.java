package cn.van.spring.use.bean.copy.model;

import lombok.Data;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserVO
 *
 * @author: Van
 * Date:     2020-01-01 11:07
 * Description: 传递给客户端的模型
 * Version： V1.0
 */
@Data
public class UserVO {
    private Long userId;
    private String userName;
    private Integer age;
    private String sex;
}
