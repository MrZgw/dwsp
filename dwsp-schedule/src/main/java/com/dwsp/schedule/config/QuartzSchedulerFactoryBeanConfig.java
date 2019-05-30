//package com.dwsp.schedule.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
//import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
///**
// * @ClassName QuartzConfig
// * @Description
// * @Author Mint
// * @Date 2019/5/17 18:06
// **/
//@Configuration
//public class QuartzSchedulerFactoryBeanConfig implements SchedulerFactoryBeanCustomizer {
//
//    @Autowired
//    private HikariDataSource dataSource;
//
//    @Override
//    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
//        schedulerFactoryBean.setDataSource(dataSource);
//    }
//}
