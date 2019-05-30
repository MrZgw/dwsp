package com.dwsp.lock.autoconfigure;

import com.dwsp.lock.LockExecutor;
import com.dwsp.lock.LockTemplate;
import com.dwsp.lock.RedisTemplateLockExecutor;
import com.dwsp.lock.aop.LockAnnotationAdvisor;
import com.dwsp.lock.aop.LockInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName LockAutoConfiguration
 * @Description 自动化配置类
 * @Author zhanguowei
 * @Date 2019/5/16 18:46
 **/
@Configuration
public class LockAutoConfiguration {

    public LockAutoConfiguration() {
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass({RedisTemplate.class})
    public LockExecutor lockExecutor(RedisTemplate redisTemplate) {
        RedisTemplateLockExecutor redisTemplateLockExecutor = new RedisTemplateLockExecutor();
        redisTemplateLockExecutor.setRedisTemplate(redisTemplate);
        return redisTemplateLockExecutor;
    }

    @Bean
    @ConditionalOnMissingBean
    public LockTemplate lockTemplate(LockExecutor lockExecutor) {
        LockTemplate lockTemplate = new LockTemplate();
        lockTemplate.setLockExecutor(lockExecutor);
        return lockTemplate;
    }

    @Bean
    @ConditionalOnMissingBean
    public LockAnnotationAdvisor lockAnnotationAdvisor(LockInterceptor lockInterceptor) {
        return new LockAnnotationAdvisor(lockInterceptor);
    }

    @Bean
    @ConditionalOnMissingBean
    public LockInterceptor lockInterceptor(LockTemplate lockTemplate) {
        LockInterceptor lockInterceptor = new LockInterceptor();
        lockInterceptor.setLockTemplate(lockTemplate);
        return lockInterceptor;
    }
}
