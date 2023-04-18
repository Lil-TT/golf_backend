package com.qinhu.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
@Component
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean expire(String key, long time) {
        if (time > 0L) {
            return this.redisTemplate.expire(key, time, TimeUnit.SECONDS).booleanValue();
        }
        return false;
    }

    public long getExpire(String key) {
        return this.redisTemplate.getExpire(key, TimeUnit.SECONDS).longValue();
    }

    public boolean hasKey(String key) {
        return this.redisTemplate.hasKey(key).booleanValue();
    }

    public Object get(String key) {
        return key == null ? null : this.redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public boolean set(String key, Object value, long time) {
        if (time > 0L) {
            this.redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            set(key, value);
        }
        return true;
    }

    public Long incr(String key) {
        return this.redisTemplate.opsForValue().increment(key);
    }
    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几
     * @return 增加后的 key 的值
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }


    public Long decr(String key) {
        return this.redisTemplate.opsForValue().decrement(key);
    }

    /**
     * 设置hash值的字段的值
     *
     * @param key
     *            hashkey
     * @param value
     *            值
     */
    public void setHash(String key, String hashKey, Object value) {
        this.redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 删除对应的字段
     *
     * @param key
     */
    public void deleteHash(String key, Object... hashKeys) {
        this.redisTemplate.opsForHash().delete(key, hashKeys);
    }

    /**
     * 校验某个字段是否存在
     *
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hasKey(String key, String hashKey) {
        return this.redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * 获取key的值
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Object getKey(String key, String hashKey) {
        return this.redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 获取指定key的所有的字段
     *
     * @param key
     * @return
     */
    public Set<Object> hashKeys(String key) {
        return this.redisTemplate.opsForHash().keys(key);
    }

    /**
     * 根据模糊的key匹配获取所有的key
     *
     * @param key
     * @return
     */
    public Set<String> keys(String key) {
        return this.redisTemplate.keys("*"+key+"*");
    }

    /**
     * 获取指定key的所有的字段值
     *
     * @param key
     * @return
     */
    public List<Object> values(String key) {
        return this.redisTemplate.opsForHash().values(key);
    }

    /**
     * 获取指定key下所有的字段和值
     *
     * @param key
     * @return
     */
    public Map<Object, Object> entries(String key) {
        return this.redisTemplate.opsForHash().entries(key);
    }

}

