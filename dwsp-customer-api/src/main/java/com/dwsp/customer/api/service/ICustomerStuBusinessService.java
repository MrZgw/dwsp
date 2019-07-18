package com.dwsp.customer.api.service;

import com.dwsp.customer.api.dto.CustomerStuDto;

import java.util.List;

/**
 * @InterfaceName ICustomerStuService
 * @Description 测试
 * @Author zhanguowei
 * @Date 2019/4/30 14:05
 **/
public interface ICustomerStuBusinessService {

    Boolean saveCustomerStu(CustomerStuDto customerStu);

    List<CustomerStuDto> getCustomerStu();
}
