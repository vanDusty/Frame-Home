package com.van.dusty.redis;

public enum CacheTypeEnum {
    L1Cache("1级缓存"),
    L2Cache("2级缓存");

    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private CacheTypeEnum(String desc) {
        this.desc = desc;
    }
}
