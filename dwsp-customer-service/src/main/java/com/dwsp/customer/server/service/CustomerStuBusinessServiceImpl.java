package com.dwsp.customer.server.service;


import com.dwsp.customer.api.dto.CustomerStuDto;
import com.dwsp.customer.api.service.ICustomerStuBusinessService;
import com.dwsp.customer.entity.CustomerStu;
import com.dwsp.customer.enums.StuSexEnum;
import com.dwsp.customer.service.CustomerStuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName CustomerStuServiceImpl
 * @Description
 * @Author Mint
 * @Date 2019/4/30 14:07
 **/
@Service
@Slf4j
public class CustomerStuBusinessServiceImpl implements ICustomerStuBusinessService {

    @Autowired
    private CustomerStuService customerStuService;

    @Override
    public Boolean saveCustomerStu(CustomerStuDto dto) {

        CustomerStu customerStu = new CustomerStu();
        BeanUtils.copyProperties(dto, customerStu);
        customerStu.setStuSex(StuSexEnum.valueOf(dto.getStuSex()));
        log.info("customerStu is [{}]", customerStu.toString());
        return customerStuService.save(customerStu);
    }

    @Override
    public List<CustomerStuDto> queryCustomerStu() {

        List<CustomerStuDto> resultList = new LinkedList<>();
        List<CustomerStu> customerStuList = customerStuService.list();
        customerStuList.forEach(customerStu -> {
            CustomerStuDto customerStuDto = new CustomerStuDto();
            BeanUtils.copyProperties(customerStu, customerStuDto);
            resultList.add(customerStuDto);
        });
        return resultList;
    }
}
