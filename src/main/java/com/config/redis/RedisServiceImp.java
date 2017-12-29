package com.config.redis;

import org.springframework.stereotype.Service;

@Service(value = "redisService")
public class RedisServiceImp extends AbstractRedisDao<String, String> implements RedisService {

    @Override
    public void setStr(String key, String value) {
        getRedisTemplate().opsForValue().set(key, value);
    }

    @Override
    public String getStr(String key) {
        return getRedisTemplate().opsForValue().get(key);
    }

    @Override
    public void rPushList(String key, String value) {
        getRedisTemplate().opsForList().rightPush(key, value);

    }

    @Override
    public String lPopList(String key) {
        return getRedisTemplate().opsForList().leftPop(key);
    }

    @Override
    public void delKey(String key) {
        getRedisTemplate().delete(key);
    }
}
