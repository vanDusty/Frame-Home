package cn.van.mybatis.druid.entity;

import java.io.Serializable;

public class UserInfoDruidDO implements Serializable {
    private Long id;

    private String userName;

    private Integer userAge;

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

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserInfoDruidDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}