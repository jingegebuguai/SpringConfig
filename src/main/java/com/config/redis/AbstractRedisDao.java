package com.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class AbstractRedisDao<K, V> {

    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

    // 设置redisTemplate
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }
}