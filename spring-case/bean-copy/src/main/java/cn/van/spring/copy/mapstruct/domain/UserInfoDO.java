package cn.van.spring.copy.mapstruct.domain;

import lombok.Data;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserDO
 *
 * @author: Van
 * Date:     2019-11-02 17:49
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Data
public class UserInfoDO {

    private Integer sex;


    public UserInfoDO(){

    }

    public UserInfoDO(Integer sex) {
        this.sex = sex;
    }
}
