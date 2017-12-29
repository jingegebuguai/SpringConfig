package com.config.redis;

public interface RedisService {

    public void setStr(String key, String value);

    public String getStr(String key);

    public void rPushList(String key, String value);

    public String lPopList(String key);

    public void delKey(String key);

}