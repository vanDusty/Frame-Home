package cn.van.multipledata.demo.service;

import cn.van.multipledata.demo.entity.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 主库（master）的全部用户数据
     *
     * @return
     */
    List<UserInfo> selectMaster();

    /**
     * 从库(slave1)全部用户数据
     *
     * @return
     */
    List<UserInfo> selectSlave();

}
