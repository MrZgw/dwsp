package com.dwsp.schedule.job;

import com.dwsp.customer.api.service.ICustomerStuBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestScheduleJob
 * @Description
 * @Author Mint
 * @Date 2019/5/17 14:46
 **/
@Slf4j
@Component
public class TestScheduleJob extends QuartzJobBean {

    @Reference
    private ICustomerStuBusinessService customerStuBusinessService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        long startTime = System.currentTimeMillis();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始执行任务-[TestScheduleJob]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info("customer info {}", customerStuBusinessService.getCustomerStu());
        long endTime = System.currentTimeMillis();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>任务-[TestScheduleJob]执行结束，耗时{}ms>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", endTime - startTime);
    }
}
