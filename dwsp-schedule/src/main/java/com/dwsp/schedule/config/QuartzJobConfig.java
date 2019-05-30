package com.dwsp.schedule.config;

import com.dwsp.schedule.job.TestScheduleJob;
import lombok.Data;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

/**
 * @ClassName QuartzJobConfig
 * @Description 定时任务配置
 * @Author Mint
 * @Date 2019/5/17 14:51
 **/
@Configuration
public class QuartzJobConfig {

    @Bean
    public JobDetail testScheduleJobDetail() {
        return JobBuilder.newJob(TestScheduleJob.class).storeDurably(true).build();
    }

    @Bean
    public CronTrigger testScheduleJobTrigger() {
        // Cron类型：通过cron表达式设置触发规则
        CronScheduleBuilder csb = CronScheduleBuilder.cronSchedule(String.format("0 */1 * * * ?"))
                .withMisfireHandlingInstructionDoNothing();

        // 一个Trigger只对应一个Job，Schedule调度器调度Trigger执行对应的Job
        CronTrigger cTrigger = TriggerBuilder.newTrigger().forJob(testScheduleJobDetail())
                .withIdentity("helloCronTrigger")
                .withDescription("corn类型的触发器")
                .withSchedule(csb)
                .startNow()
                .build();
        return cTrigger;
    }
}
