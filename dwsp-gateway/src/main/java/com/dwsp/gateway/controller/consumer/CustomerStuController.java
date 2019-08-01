package com.dwsp.gateway.controller.consumer;

import com.dwsp.customer.api.dto.CustomerStuDto;
import com.dwsp.customer.api.service.ICustomerStuBusinessService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CustomerStuController
 * @Description
 * @Author Mint
 * @Date 2019/4/30 14:26
 **/
@RestController
@RequestMapping("/customer/stu")
public class CustomerStuController {

    @Reference
    private ICustomerStuBusinessService customerStuBusinessService;

    @Value("${test.value}")
    private String testValue;

    @GetMapping("/list")
    public List<CustomerStuDto> query() {
        return customerStuBusinessService.getCustomerStu();
    }

    @GetMapping("/save")
    public Boolean save() {
        CustomerStuDto customerStu = new CustomerStuDto();
        customerStu.setStuName("张三");
        customerStu.setStuSex("MAN");
        customerStu.setStuAge(30);
        customerStu.setStuCellPhone("10086");
        return customerStuBusinessService.saveCustomerStu(customerStu);
    }

    @GetMapping("/testValue")
    public String testValue() {
        return testValue;
    }
}
