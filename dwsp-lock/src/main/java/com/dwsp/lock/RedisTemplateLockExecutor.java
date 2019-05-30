package com.dwsp.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;

/**
 * @ClassName RedisTemplateLockExecutor
 * @Description 锁操作实现类
 * @Author zhanguowei
 * @Date 2019/5/16 17:27
 **/
@Slf4j
public class RedisTemplateLockExecutor implements LockExecutor {

    private static final RedisScript<String> SCRIPT_LOCK = new DefaultRedisScript("return redis.call('set',KEYS[1],ARGV[1],'NX','PX',ARGV[2])", String.class);
    private static final RedisScript<String> SCRIPT_UNLOCK = new DefaultRedisScript("if redis.call('get',KEYS[1]) == ARGV[1] then return tostring(redis.call('del', KEYS[1])==1) else return 'false' end", String.class);
    private static final String LOCK_SUCCESS = "OK";

    private RedisTemplate redisTemplate;

    public RedisTemplateLockExecutor() {
    }

    @Override
    public boolean acquire(String lockKey, String lockValue, long acquireExpire) {
        Object result = redisTemplate.execute(SCRIPT_LOCK, this.redisTemplate.getStringSerializer(), this.redisTemplate.getStringSerializer(), Collections.singletonList(lockKey), new Object[]{lockValue, String.valueOf(acquireExpire)});
        return LOCK_SUCCESS.equals(result);
    }

    @Override
    public boolean release(LockInfo lockInfo) {
        Object result = redisTemplate.execute(SCRIPT_UNLOCK, this.redisTemplate.getStringSerializer(), this.redisTemplate.getStringSerializer(), Collections.singletonList(lockInfo.getLockKey()), new Object[]{lockInfo.getLockValue()});
        return Boolean.valueOf(result.toString());
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
