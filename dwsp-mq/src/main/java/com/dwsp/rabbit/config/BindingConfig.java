package com.dwsp.rabbit.config;

import com.dwsp.rabbit.constant.RouteKeyConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BindingConfig
 * @Description 队列交换机绑定
 * @Author zhanguowei
 * @Date 2019/5/8 15:31
 **/
@Configuration
public class BindingConfig {

    /**
     * customer队列绑定到commonExchange
     *
     * @param commonExchange
     * @param customerQueue
     * @return
     */
    @Bean
    public Binding bindingExchange(TopicExchange commonExchange, Queue customerQueue) {
        return BindingBuilder.bind(customerQueue)
                .to(commonExchange)
                .with(RouteKeyConstant.CUSTOMER_ROUTE_KEY);
    }

    /**
     * ttl队列绑定到delayExchange
     *
     * @param delayExchange
     * @param delayQueue
     * @return
     */
    @Bean
    public Binding delayBindingExchange(TopicExchange delayExchange, Queue delayQueue) {
        return BindingBuilder.bind(delayQueue)
                .to(delayExchange)
                .with(RouteKeyConstant.DELAY_KEY);
    }

}
