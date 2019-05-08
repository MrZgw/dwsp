package com.dwsp.rabbit.mq.config;

import com.dwsp.rabbit.mq.constant.ExchangeConstant;
import com.dwsp.rabbit.mq.constant.QueueConstant;
import com.dwsp.rabbit.mq.constant.RouteKeyConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName QueueConfig
 * @Description 队列配置
 * @Author zhanguowei
 * @Date 2019/5/8 14:54
 **/
@Configuration
public class QueueConfig {

    /**
     * customer消费队列
     *
     * @return
     */
    @Bean
    public Queue customerQueue() {
        return QueueBuilder.durable(QueueConstant.CUSTOMER_QUEUE).build();
    }

    /**
     * 延迟消费队列
     *
     * @return
     */
    @Bean
    public Queue delayQueue() {
        return QueueBuilder.durable(QueueConstant.DELAY_QUEUE)
                .withArgument("x-message-ttl", 10000)
                //消息变成死信后，转发到"x-dead-letter-exchange"配置的交换机
                .withArgument("x-dead-letter-exchange", ExchangeConstant.COMMON_EXCHANGE)
                // 配置到期后转发的路由键
//                .withArgument("x-dead-letter-routing-key", RouteKeyConstant.DELAY_TO_CUSTOMER_ROUTE_KEY)
                .build();
    }
}
