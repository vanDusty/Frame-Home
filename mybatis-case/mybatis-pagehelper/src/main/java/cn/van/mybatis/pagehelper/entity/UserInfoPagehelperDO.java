package cn.van.mybatis.pagehelper.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfoPagehelperDO implements Serializable {
    private Long id;

    private String userName;

    private Integer age;

    private Date createTime;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserInfoPagehelperDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                '}';
    }
}