package com.dwsp.customer.test;

import com.dwsp.customer.server.DwspCustomerServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * @ClassName RedisTest
 * @Description redis测试类
 * @Author zhanguowei
 * @Date 2019/4/30 18:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DwspCustomerServiceApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("first", "firstKey");
    }
}
