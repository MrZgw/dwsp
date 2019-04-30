package com.dwsp.customer.api.service;


import com.dwsp.customer.api.dto.TestDto;

/**
 * @ClassName ITestService
 * @Description 测试接口
 * @Author zhanguowei
 * @Date 2019/4/29 17:16
 **/
public interface ITestService {

    /**
     * 测试方法
     *
     * @return
     */
    TestDto getTestDto(String testId);
}
