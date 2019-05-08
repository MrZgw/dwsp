package com.dwsp.rabbit.mq.sender;

import lombok.NonNull;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Map;

/**
 * @InterfaceName RabbitMqSendService
 * @Description rabbitmq发送者
 * @Author zhanguowei
 * @Date 2019/5/6 16:14
 **/
public interface IRabbitMqSendService extends RabbitTemplate.ConfirmCallback {

    /**
     * 发送普通消息
     *
     * @param exchangeName   交换机名称
     * @param routeKey       路由key
     * @param messageContent 消息
     * @param param          自定义参数
     */
    void sendMessage(@NonNull String exchangeName, @NonNull String routeKey, @NonNull Object messageContent, Map<String, Object> param);

    /**
     * 发送延迟消息
     *
     * @param exchangeName   交换机名称
     * @param routeKey       路由key
     * @param messageContent 消息
     * @param delayTimes     延迟时间,毫秒为单位
     */
    void sendDelayMessage(@NonNull String exchangeName, @NonNull String routeKey, @NonNull Object messageContent, @NonNull Long delayTimes);

}
