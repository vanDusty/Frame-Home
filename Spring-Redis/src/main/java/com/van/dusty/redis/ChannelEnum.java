package com.van.dusty.redis;

public enum ChannelEnum {
    CacheChannel("缓存channel");

    private String desc;

    private ChannelEnum(String desc) {
        this.desc = desc;
    }
}
