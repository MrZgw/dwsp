package com.dwsp.lock.aop;


import com.dwsp.lock.LockInfo;
import com.dwsp.lock.LockKeyGenerator;
import com.dwsp.lock.LockTemplate;
import com.dwsp.lock.annotation.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @ClassName LockInterceptor
 * @Description 方法拦截器
 * @Author zhanguowei
 * @Date 2019/5/16 18:23
 **/
@Slf4j
public class LockInterceptor implements MethodInterceptor {

    private LockTemplate lockTemplate;

    private final LockKeyGenerator lockKeyGenerator = new LockKeyGenerator();

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        LockInfo lockInfo = null;

        Object var5;
        try {
            RedisLock redisLock = methodInvocation.getMethod().getAnnotation(RedisLock.class);
            String keyName = lockKeyGenerator.getKeyName(methodInvocation, redisLock);
            lockInfo = this.lockTemplate.lock(keyName, redisLock.expire(), redisLock.timeout());
            if (null == lockInfo) {
                var5 = null;
                return var5;
            }

            var5 = methodInvocation.proceed();
        } finally {
            if (null != lockInfo) {
                this.lockTemplate.unlock(lockInfo);
            }
        }
        return var5;
    }

    public void setLockTemplate(LockTemplate lockTemplate) {
        this.lockTemplate = lockTemplate;
    }
}
