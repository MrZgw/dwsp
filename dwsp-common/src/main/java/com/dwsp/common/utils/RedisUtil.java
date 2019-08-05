package com.dwsp.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * redis操作工具类
 *
 * @author zgw
 * @date 2019-07-23
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 字符串set操作
     *
     * @param key
     * @param value
     */
    public void setString(@NonNull String key, @NonNull String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 字符串get操作
     *
     * @param key
     */
    public void getString(@NonNull String key) {
        redisTemplate.opsForValue().get(key);
    }

    /**
     * List 单个 push 操作
     *
     * @param key
     * @param obj
     */
    public void setListLeft(@NonNull String key, Object obj) {
        if (obj != null) {
            redisTemplate.opsForList().leftPush(key, obj);
        }
    }

    /**
     * List 多个 push 操作
     *
     * @param key
     * @param list
     */
    public void setListLeftAll(@NonNull String key, List list) {
        if (list != null && list.size() > 0) {
            redisTemplate.opsForList().leftPushAll(key, list);
        }
    }

    /**
     * List pop 操作
     *
     * @param key
     * @return
     */
    public List getListRightAll(@NonNull String key) {
        return (List) redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * map set操作
     *
     * @param key
     * @param map
     */
    public void setHash(@NonNull String key, Map map) {
        if (map != null && !map.isEmpty()) {
            redisTemplate.opsForHash().putAll(key, map);
        }
    }

    /**
     * map get操作
     *
     * @param key
     * @return
     */
    public Map getHash(@NonNull String key) {
        return redisTemplate.opsForHash().entries(key);
    }

}
