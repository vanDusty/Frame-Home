package cn.van.spring.copy.mapstruct.domain;

import lombok.Data;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserInfoDTO
 *
 * @author: Van
 * Date:     2019-11-02 17:53
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Data
public class UserInfoDTO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户名
     */
    private String password;

    /**
     * 生日
     */
    private String brothStr;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 喜好
     */
    private String favorite;

}