package com.dwsp.rabbit.mq.sender;

import lombok.NonNull;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @InterfaceName RabbitMqSendService
 * @Description rabbitmq发送者
 * @Author zhanguowei
 * @Date 2019/5/6 16:14
 **/
public interface IRabbitMqSendService extends RabbitTemplate.ConfirmCallback {

    void sendMessage(@NonNull String exchangeName, @NonNull String routeKey, @NonNull Object message);

}
