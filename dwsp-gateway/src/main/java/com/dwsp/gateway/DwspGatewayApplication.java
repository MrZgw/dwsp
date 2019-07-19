package com.dwsp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName DwspCustomerWebApplication
 * @Description 网关启动类
 * @Author zhanguowei
 * @Date 2019/4/29 18:08
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.dwsp")
public class DwspGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwspGatewayApplication.class, args);
    }
}
