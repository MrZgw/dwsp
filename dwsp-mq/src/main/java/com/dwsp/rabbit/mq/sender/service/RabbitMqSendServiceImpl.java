package com.dwsp.rabbit.mq.sender.service;

import com.dwsp.rabbit.mq.sender.IRabbitMqSendService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @ClassName RabbitMqSendServiceImpl
 * @Description rabbitmq消息发送实现类
 * @Author zhanguowei
 * @Date 2019/5/6 16:18
 **/
@Service
@Slf4j
public class RabbitMqSendServiceImpl implements IRabbitMqSendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String exchangeName, String routeKey, Object messageContent, Map<String, Object> param) {
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调id为uuid
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        log.info("send message exchange is [{}],route key is [{}],messageId is [{}],message is [{}]", exchangeName, routeKey, correlationId, messageContent);
        rabbitTemplate.convertAndSend(exchangeName, routeKey, messageContent, message -> {
            if (!Objects.isNull(param)) {
                Map<String, Object> messageMap = message.getMessageProperties().getHeaders();
                messageMap.putAll(param);
            }
            return message;
        }, correlationId);
    }

    @Override
    public void sendDelayMessage(@NonNull String exchangeName, @NonNull String routeKey, @NonNull Object messageContent, @NonNull Long delayTimes) {
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调id为uuid
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        log.info("send message exchange is [{}],route key is [{}],messageId is [{}],message is [{}]", exchangeName, routeKey, correlationId, messageContent);
        rabbitTemplate.convertAndSend(exchangeName, routeKey, messageContent, message -> {
            message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
            return message;
        }, correlationId);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("message send success......");
        } else {
            log.error("message send fail [{}]message id is [{}]", cause, correlationData.getId());
        }
    }
}
