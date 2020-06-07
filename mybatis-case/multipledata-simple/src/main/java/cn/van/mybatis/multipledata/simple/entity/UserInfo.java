/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   zhangfan
 * Date:     2019-03-29 15:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.van.mybatis.multipledata.simple.entity;

import java.time.LocalDateTime;

public class UserInfo {
    private Long id;
    private String userName;
    private String passWord;
    private String userSex;
    private String nickName;
    private LocalDateTime gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userSex='" + userSex + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}