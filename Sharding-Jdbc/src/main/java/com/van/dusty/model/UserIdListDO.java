package com.van.dusty.model;

public class UserIdListDO {
    private Long id;

    private Integer isUser;

    public UserIdListDO(Integer isUser) {
        this.isUser = isUser;
    }

    public UserIdListDO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsUser() {
        return isUser;
    }

    public void setIsUser(Integer isUser) {
        this.isUser = isUser;
    }
}