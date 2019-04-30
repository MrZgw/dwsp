package com.dwsp.customer.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName DwspCustomerWebApplication
 * @Description customer消费端启动类
 * @Author zhanguowei
 * @Date 2019/4/29 18:08
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.dwsp")
@Transactional
@ServletComponentScan
public class DwspCustomerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwspCustomerWebApplication.class, args);
    }
}
