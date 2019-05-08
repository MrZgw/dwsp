package com.dwsp.rabbit.mq.constant;

/**
 * @ClassName ExchangeConstant
 * @Description 交换机常量配置
 * @Author zhanguowei
 * @Date 2019/5/6 15:56
 **/
public interface ExchangeConstant {

    /**
     * 通用交换机
     */
    String COMMON_EXCHANGE = "common.exchange";

    /**
     * TTL交换机
     */
    String DELAY_EXCHANGE = "delay.exchange";


}
