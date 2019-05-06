package com.dwsp.rabbit.mq.consumer;

import com.dwsp.rabbit.mq.enums.QueueConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.zip.CheckedInputStream;

/**
 * @InterfaceName IRabbitMqConsumerService
 * @Description rabbitmq消费者接口
 * @Author zhanguowei
 * @Date 2019/5/6 16:46
 **/
@Slf4j
@Component
public class RabbitMqCustomerConsumer {

    @RabbitListener(queues = {"customer.queue"})
    @RabbitHandler
    public void process(Message message, Channel channel, String content) {
        log.info("consumer receive message [{}]", content);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("receive fail [{}]", e.getMessage());
//          channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
        }
    }

}
