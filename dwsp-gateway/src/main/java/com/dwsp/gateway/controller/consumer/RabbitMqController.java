package com.dwsp.gateway.controller.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RabbitMqController
 * @Description
 * @Author Mint
 * @Date 2019/5/8 14:00
 **/
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {

    @Autowired
//    private RabbitMqCustomerConsumer rabbitMqCustomerConsumer;

    @GetMapping("/test")
    public String getMessage() {
        return "hello";
    }
}
