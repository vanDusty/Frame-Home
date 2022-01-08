package cn.van.spring.copy.mapstruct.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: RoleDO
 *
 * @author: Van
 * Date:     2019-11-02 17:49
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@Data
public class RoleDO {

    private Long id;
    private String roleName;
    private String description;

    public RoleDO() {

    }

    public RoleDO(Long id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }
}