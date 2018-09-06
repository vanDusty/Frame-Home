package com.van.dusty.redis;

public enum CacheKeyEnum {
    MissionDefine("任务定义", Integer.valueOf(300)),
    Form("表单", Integer.valueOf(600)),
    AccessKey("APP秘钥", Integer.valueOf(400)),
    NotificationCopy("配置文案", Integer.valueOf(500));

    private String desc;
    private Integer CacheTime;

    public String getDesc() {
        return this.desc;
    }

    public Integer getCacheTime() {
        return this.CacheTime;
    }

    private CacheKeyEnum(String desc, Integer cacheTime) {
        this.desc = desc;
        this.CacheTime = cacheTime;
    }
}
