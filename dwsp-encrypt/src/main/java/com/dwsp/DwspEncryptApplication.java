package com.dwsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DwspEncryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwspEncryptApplication.class, args);
    }
}
