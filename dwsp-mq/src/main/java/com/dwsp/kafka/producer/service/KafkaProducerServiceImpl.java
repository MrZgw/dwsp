package com.dwsp.kafka.producer.service;

import com.dwsp.kafka.producer.IKafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@Slf4j
public class KafkaProducerServiceImpl implements IKafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 默认的消息发送方法
     *
     * @param topic 主题
     * @param key   消息key
     * @param data  消息body
     */
    @Override
    public void defaultSendMessage(String topic, String key, Object data) {
        log.info("发送消息到[{}],消息内容:{}", topic, data);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, data);
        future.addCallback(success -> {
            log.info("消息发送成功:{}", success);
        }, fail -> {
            log.info("消息发送失败:{]", fail);
        });
    }
}
