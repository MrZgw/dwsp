package com.dwsp.customer.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName DwspCustomerServiceApplication
 * @Description customer启动类
 * @Author zhangguowei
 * @Date 2019/4/29 15:49
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.dwsp")
@EnableTransactionManagement
@MapperScan("com.dwsp.customer.mapper")
public class DwspCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwspCustomerServiceApplication.class, args);
    }
}
