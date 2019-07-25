package com.dwsp.customer.service;

import com.dwsp.kafka.producer.constant.KafkaTopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class KafkaMessageConsumer {

    @KafkaListener(topics = {KafkaTopicConstant.CONSUMER_TOPIC})
    public void receive(List<ConsumerRecord<String, Object>> consumerRecordList, Acknowledgment acknowledgment) {

        log.info("消息数量:{}", consumerRecordList.size());
        consumerRecordList.stream().forEach(consumerRecord -> {
            log.info("主题[{}],消息KEY:{},消息内容:{}", consumerRecord.topic(), consumerRecord.key(), consumerRecord.value());
        });
        acknowledgment.acknowledge();
    }
}
