package com.dwsp.customer.server.service;

import com.dwsp.customer.server.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * @ClassName TestServiceImpl
 * @Description 测试接口实现类
 * @Author zhanguowei
 * @Date 2019/4/29 17:19
 **/
@Service
@Slf4j
public class TestServiceImpl implements ITestService {

    /**
     * 测试方法
     *
     * @param testId
     * @return
     */
    @Override
    public TestDto getTestDto(String testId) {
        log.info("receive customer tesId {}", testId);
        return new TestDto("10000", "测试信息");
    }
}
