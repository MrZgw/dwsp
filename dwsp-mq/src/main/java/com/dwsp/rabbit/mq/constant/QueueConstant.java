package com.dwsp.rabbit.mq.constant;

/**
 * @EnumName QueueConstant
 * @Description 队列常量
 * @Author zhanguowei
 * @Date 2019/5/6 15:41
 **/
public interface QueueConstant {
    /**
     * customer消费队列
     */
    String CUSTOMER_QUEUE = "customer.queue";

    /**
     * 延迟队列
     */
    String DELAY_QUEUE = "delay.queue";
}
