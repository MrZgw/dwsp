package com.dwsp.customer.test;

import com.dwsp.customer.DwspCustomerServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

/**
 * @ClassName RedisTest
 * @Description redis测试类
 * @Author zhanguowei
 * @Date 2019/4/30 18:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DwspCustomerServiceApplication.class)
@Slf4j
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
//        redisTemplate.opsForValue().set("test", "test");
//        String str = (String) redisTemplate.opsForValue().get("test");
//        log.info(str);

//        CustomerStu customerStu = new CustomerStu();
//        customerStu.setId(1L);
//        customerStu.setStuName("李四");
//        customerStu.setStuSex(StuSexEnum.MAN);
//        customerStu.setStuAge(29);
//        customerStu.setStuCellPhone("123456");
//        redisTemplate.opsForValue().set("customerStu", customerStu);
//        CustomerStu result = (CustomerStu) redisTemplate.opsForValue().get("customerStu");
//        log.info(result.toString());


//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            Map<String, String> stuMap = new HashMap<>(16);
//            stuMap.put("id", String.valueOf(i + 1));
//            stuMap.put("name", "张三" + i);
//            stuMap.put("age", String.valueOf(random.nextInt(100)));
//            redisTemplate.opsForHash().putAll(stuMap.get("id"), stuMap);
//
//            redisTemplate.opsForZSet().add("customerStuList", stuMap.get("id"), Double.valueOf(stuMap.get("age")));
//        }


        Set set = redisTemplate.opsForZSet().rangeByScore("customerStuList",0,100,0,10);
        set.stream().forEach(id -> {
            Map resultMap = redisTemplate.opsForHash().entries(id);
            log.info(resultMap.toString());
        });

    }
}
