package cn.van.mybatis.druid.web.controller;


import cn.van.mybatis.druid.entity.UserInfoDruidDO;
import cn.van.mybatis.druid.mapper.UserInfoDruidMapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: UserController
 *
 * @author: Van
 * Date:     2019-07-26 12:07
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@RestController
@RequestMapping("/mybatisDruid")
@Api(tags = {"Druid 测试"})
public class DruidController {

    @Resource
    UserInfoDruidMapper userInfoDruidMapper;

    @GetMapping("/selectOne")
    public UserInfoDruidDO selectOne(Long id) {
        return userInfoDruidMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/selectAll")
    public List<UserInfoDruidDO> selectAll() {
        return userInfoDruidMapper.selectAll();
    }
}
