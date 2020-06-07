package cn.van.multipledata.demo.service.impl;

import cn.van.multipledata.demo.annotation.DS;
import cn.van.multipledata.demo.entity.UserInfo;
import cn.van.multipledata.demo.enums.DynamicDSEnum;
import cn.van.multipledata.demo.mapper.UserMapper;
import cn.van.multipledata.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<UserInfo> selectMaster() {
        return userMapper.selectAll();
    }

    @DS(value = DynamicDSEnum.SLAVE)
    @Override
    public List<UserInfo> selectSlave() {
        return userMapper.selectAll();
    }
}
