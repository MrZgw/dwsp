package com.dwsp.customer.test;

import com.dwsp.customer.api.dto.CustomerStuDto;
import com.dwsp.customer.entity.CustomerStu;
import com.dwsp.customer.server.DwspCustomerServiceApplication;
import com.dwsp.rabbit.mq.constant.ExchangeConstant;
import com.dwsp.rabbit.mq.sender.IRabbitMqSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RabbitMqTest
 * @Description rabbitmq测试类
 * @Author zhanguowei
 * @Date 2019/5/8 13:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DwspCustomerServiceApplication.class)
public class RabbitMqTest {

    @Autowired
    private IRabbitMqSendService rabbitMqSendService;

    @Test
    public void sendMessage() {
        CustomerStuDto customerStu = new CustomerStuDto();
        customerStu.setId(1000L);
        customerStu.setStuName("王五");
        customerStu.setStuAge(30);
        rabbitMqSendService.sendMessage(ExchangeConstant.COMMON_EXCHANGE, "customer.test", customerStu);
    }
}
