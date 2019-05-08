package com.dwsp.rabbit.mq.config;

import com.dwsp.rabbit.mq.constant.ExchangeConstant;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ExchangeConfig
 * @Description 交换机配置
 * @Author zhanguowei
 * @Date 2019/5/8 15:23
 **/
@Configuration
public class ExchangeConfig {

    @Bean
    public TopicExchange commonExchange() {
        return (TopicExchange) ExchangeBuilder.topicExchange(ExchangeConstant.COMMON_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    public TopicExchange delayExchange() {
        return (TopicExchange) ExchangeBuilder.topicExchange(ExchangeConstant.DELAY_EXCHANGE)
                .durable(true)
                .build();
    }
}
