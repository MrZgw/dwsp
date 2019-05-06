package com.dwsp.rabbit.mq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ExchangeConstant
 * @Description 交换机常量配置
 * @Author zhanguowei
 * @Date 2019/5/6 15:56
 **/
@Getter
@AllArgsConstructor
public enum ExchangeConstant {

    COMMON_EXCHANGE("common.exchange", "通用exchange");

    private String value;
    private String desc;

}
