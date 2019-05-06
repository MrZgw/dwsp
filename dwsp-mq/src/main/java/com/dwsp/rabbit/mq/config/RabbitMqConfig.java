package com.dwsp.rabbit.mq.config;

import com.dwsp.rabbit.mq.constant.ExchangeConstant;
import com.dwsp.rabbit.mq.constant.QueueConstant;
import com.dwsp.rabbit.mq.constant.RouteKeyConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitMqConfig
 * @Description rabbitmq配置
 * @Author zhanguowei
 * @Date 2019/5/5 17:50
 **/
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue customerQueue() {
        return new Queue(QueueConstant.CUSTOMER_QUEUE);
    }

    @Bean
    public Exchange commonExchange() {
        return new TopicExchange(ExchangeConstant.COMMON_EXCHANGE);
    }

    @Bean
    public Binding bindingExchange(TopicExchange commonExchange, Queue customerQueue) {
        return BindingBuilder.bind(customerQueue).to(commonExchange).with(RouteKeyConstant.CUSTOMER_KEY);
    }

}
