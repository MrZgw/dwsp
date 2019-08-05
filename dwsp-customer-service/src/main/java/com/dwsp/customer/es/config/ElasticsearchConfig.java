//package com.dwsp.customer.es.config;
//
//import com.dwsp.common.config.RedisConfig;
//import org.elasticsearch.client.Client;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
//import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
//import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;
//
///**
// * @Description: es 配置类<br>
// * @Project: dwsp <br>
// * @CreateDate: Created in 2019/8/2 17:19 <br>
// * @Author: <a href="zgw@qq.com">zgw</a>
// */
//
//@Configuration
///**
// * es自动配置必须在redis自动配置之前
// * 原因:程序的其他地方使用了Netty，这里指redis，这影响在实例化传输客户端之前初始化处理器的数量。
// * 实例化传输客户端时，我们尝试初始化处理器的数量。
// * 由于在其他地方使用Netty，因此已经初始化并且Netty会对此进行防范，因此首次实例化会因看到的非法状态异常而失败。
// */
//@AutoConfigureBefore(RedisConfig.class)
//public class ElasticsearchConfig {
//
//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate(Client client, ElasticsearchConverter converter) {
//        try {
//            return new ElasticsearchTemplate(client, converter);
//        } catch (Exception var4) {
//            throw new IllegalStateException(var4);
//        }
//    }
//
//    @Bean
//    public ElasticsearchConverter elasticsearchConverter(SimpleElasticsearchMappingContext mappingContext) {
//        return new MappingElasticsearchConverter(mappingContext);
//    }
//
//    @Bean
//    public SimpleElasticsearchMappingContext mappingContext() {
//        return new SimpleElasticsearchMappingContext();
//    }
//}
