package cn.van.multipledata.demo.mapper;

import cn.van.multipledata.demo.entity.UserInfo;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> selectAll();
}

