package com.dwsp.customer.test;


import com.dwsp.constant.TestValueConstant;
import com.dwsp.customer.api.dto.CustomerStuDto;
import com.dwsp.customer.server.DwspCustomerServiceApplication;
import com.dwsp.rabbit.mq.constant.ExchangeConstant;
import com.dwsp.rabbit.mq.constant.RouteKeyConstant;
import com.dwsp.rabbit.mq.sender.IRabbitMqSendService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RabbitMqTest
 * @Description rabbitmq测试类
 * @Author zhanguowei
 * @Date 2019/5/8 13:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DwspCustomerServiceApplication.class)
@Slf4j
public class RabbitMqTest {

    @Autowired
    private IRabbitMqSendService rabbitMqSendService;

    @Value(TestValueConstant.TEST_VALUE)
    private String testValue;

    @Test
    public void testValue() {
        log.info("test value is {}", testValue);
    }

    @Test
    public void sendMessage() {
        CustomerStuDto customerStu = new CustomerStuDto();
        customerStu.setId(1000L);
        customerStu.setStuName("王五");
        customerStu.setStuAge(30);
        Map<String, Object> param = new HashMap<>();
        param.put("count", 1);
        rabbitMqSendService.sendMessage(ExchangeConstant.COMMON_EXCHANGE, "customer.test", customerStu, param);
    }

    @Test
    public void sendDelayMessage() {
        CustomerStuDto customerStu = new CustomerStuDto();
        customerStu.setId(1000L);
        customerStu.setStuName("王五");
        customerStu.setStuAge(30);
        rabbitMqSendService.sendDelayMessage(ExchangeConstant.DELAY_EXCHANGE, RouteKeyConstant.DELAY_KEY, customerStu, 10000L);
    }
}
