package com.dwsp.customer.web.controller;

import com.dwsp.customer.server.dto.TestDto;
import com.dwsp.customer.server.service.ITestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 测试
 * @Author zhanguowei
 * @Date 2019/4/29 18:11
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference
    private ITestService testService;

    @GetMapping("/")
    public TestDto test() {
        return testService.getTestDto("1000");
    }
}
