package com.dwsp.customer.web.controller;

import com.dwsp.customer.api.dto.CustomerStuDto;
import com.dwsp.rabbit.mq.constant.ExchangeConstant;
import com.dwsp.rabbit.mq.constant.QueueConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @InterfaceName IRabbitMqConsumerService
 * @Description rabbitmq消费者接口
 * @Author zhanguowei
 * @Date 2019/5/6 16:46
 **/
@Slf4j
@Component
public class RabbitMqCustomerConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {QueueConstant.CUSTOMER_QUEUE})
    @RabbitHandler
    public void process(Message message, Channel channel, CustomerStuDto customerStuDto) throws IOException {
        log.info("consumer receive message [{}]", customerStuDto.toString());
        try {
            int i = 5 / 0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("receive fail [{}]", e.getMessage());
            Integer count = Integer.valueOf((message.getMessageProperties().getHeaders().get("count").toString()));
            if (count < 3) {
                message.getMessageProperties().setHeader("count",count+1);
                rabbitTemplate.send(ExchangeConstant.DELAY_EXCHANGE,"customer.delay.test",message);
            } else {
                //TODO 入库
                log.error("message consumer fail......");
            }

            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

}
