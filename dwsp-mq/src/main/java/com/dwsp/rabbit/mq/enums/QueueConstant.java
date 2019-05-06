package com.dwsp.rabbit.mq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @EnumName QueueConstant
 * @Description 队列常量
 * @Author zhanguowei
 * @Date 2019/5/6 15:41
 **/
@Getter
@AllArgsConstructor
public enum QueueConstant {
    CUSTOMER_QUEUE("customer.queue", "customer消费队列");
    private String value;
    private String desc;
}
