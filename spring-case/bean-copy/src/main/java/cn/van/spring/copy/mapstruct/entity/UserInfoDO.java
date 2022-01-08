package cn.van.spring.copy.mapstruct.entity;

import lombok.Data;
import java.util.Date;

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
public class UserInfoDO {

    private Long id;

    private String userName;

    private String password;

    private String phoneNum;

    private Date gmtBroth;

    private RoleDO role;

    public UserInfoDO() {

    }

    public UserInfoDO(RoleDO role,Long id,String userName,String password,String phoneNum,Date gmtBroth) {
        this.role = role;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
        this.gmtBroth = gmtBroth;
    }

}