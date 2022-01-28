package cn.van.mybatis.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserInfoEncryptDO implements Serializable {
    private Long id;

    private String userName;

    private Encrypt passWord;

    private String nickName;

    private String mobile;

    private String email;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;

    private static final long serialVersionUID = 1L;

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

    public Encrypt getPassWord() {
        return passWord;
    }

    public void setPassWord(Encrypt passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(LocalDateTime gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "UserInfoEncryptDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", gmtCreate=" + gmtCreate+
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }
}