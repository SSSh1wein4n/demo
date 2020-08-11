package com.personal.demo.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author shiweinan
 * @date 2020-08-11 11:13
 */
@Service
@CacheConfig(cacheNames = "demo")
public class DemoRedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 添加数据至redis
     *
     * @param key redis中的key
     * @param value redis中的value
     */
    public void addToRedis(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 通过key查询redis中的值
     *
     * @param key redis中的key
     * @return redis中对应的value
     */
    public String findByKey(String key) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 更新redis中的数据
     *
     * @param key redis中的key
     * @param value redis中的value
     * @return 是否成功
     */
    public boolean modify(String key, String value) {
        if (StringUtils.isBlank(key)) {
            return false;
        }
        return redisTemplate.opsForValue().setIfPresent(key, value);
    }

    /**
     * 删除redis中的数据
     *
     * @param key redis中的key
     * @return 是否成功
     */
    public boolean removeByKey(String key) {
        if (StringUtils.isBlank(key)) {
            return false;
        }
        boolean isSuccess = false;
        if (redisTemplate.hasKey(key)) {
            isSuccess = redisTemplate.delete(key);
        }
        return isSuccess;
    }
}
