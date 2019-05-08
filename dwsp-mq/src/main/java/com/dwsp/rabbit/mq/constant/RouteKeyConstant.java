package com.dwsp.rabbit.mq.constant;

/**
 * @EnumName RouteKeyConstant
 * @Description 路由键配置
 * @Author zhanguowei
 * @Date 2019/5/6 16:03
 **/
public interface RouteKeyConstant {

    /**
     * customer路由key
     */
    String CUSTOMER_ROUTE_KEY = "customer.#";


    /**
     * TTL队列路由键
     */
    String DELAY_KEY = "customer.delay.#";

}
