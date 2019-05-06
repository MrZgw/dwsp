package com.dwsp.rabbit.mq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @EnumName RouteKeyConstant
 * @Description 路由键配置
 * @Author zhanguowei
 * @Date 2019/5/6 16:03
 **/
@Getter
@AllArgsConstructor
public enum RouteKeyConstant {

    CUSTOMER_KEY("customer.#", "customer路由键");
    private String value;
    private String desc;

    }
