package cn.van.spring.copy.mapstruct.entity;

import lombok.Data;

/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2022/1/8 10:11 下午
 * Description:
 * Version： V1.0
 */
@Data
public class UserExtInfoDO {

    private String favorite;

    public UserExtInfoDO() {

    }

    public UserExtInfoDO(String favorite) {
        this.favorite = favorite;
    }
}