package cn.van.spring.copy.mapstruct.domain;

import lombok.Data;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserDTO
 *
 * @author: Van
 * Date:     2019-11-02 17:53
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Data
public class UserDTO {
    private Integer id;
    private String userName;
    private String gmtBroth;
    private String balances;
    private Integer sex;
}
