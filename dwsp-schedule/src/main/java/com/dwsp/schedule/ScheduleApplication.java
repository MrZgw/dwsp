package com.dwsp.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName ScheduleApplication
 * @Description 启动类
 * @Author zhanguowei
 * @Date 2019/5/17 16:20
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.dwsp")
@EnableTransactionManagement
@MapperScan("com.dwsp")
public class ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }
}
