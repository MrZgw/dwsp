package com.dwsp.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: 启动类<br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/8/13 16:00 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.dwsp")
@MapperScan("com.dwsp.order.mapper")
public class DwspOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwspOrderApplication.class, args);
    }
}
