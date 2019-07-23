package com.dwsp.customer.business.service;


import com.dwsp.common.constant.RedisKeyConstant;
import com.dwsp.common.utils.RedisUtil;
import com.dwsp.customer.api.dto.CustomerStuDto;
import com.dwsp.customer.api.service.ICustomerStuBusinessService;
import com.dwsp.customer.dao.CustomerStuService;
import com.dwsp.customer.entity.CustomerStu;
import com.dwsp.customer.enums.StuSexEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Boolean saveCustomerStu(CustomerStuDto dto) {

        CustomerStu customerStu = new CustomerStu();
        BeanUtils.copyProperties(dto, customerStu);
        customerStu.setStuSex(StuSexEnum.valueOf(dto.getStuSex()));
        log.info("customerStu is [{}]", customerStu.toString());
        Boolean result = customerStuService.save(customerStu);
        if (result) {
            redisUtil.setListLeft(RedisKeyConstant.customerKey, dto);
        }
        return result;
    }

    @Override
    public List<CustomerStuDto> getCustomerStu() {

        List<CustomerStuDto> cacheList = redisUtil.getListRightAll(RedisKeyConstant.customerKey);
        if (cacheList != null && cacheList.size() > 0) {
            return cacheList;
        }
        List<CustomerStuDto> resultList = new LinkedList<>();
        List<CustomerStu> customerStuList = customerStuService.list();
        customerStuList.forEach(customerStu -> {
            CustomerStuDto customerStuDto = new CustomerStuDto();
            BeanUtils.copyProperties(customerStu, customerStuDto);
            customerStuDto.setStuSex(customerStu.getStuSex().getDesc());
            resultList.add(customerStuDto);
        });
        return resultList;
    }
}
