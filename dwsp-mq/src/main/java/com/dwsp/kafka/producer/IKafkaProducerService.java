package com.dwsp.kafka.producer;

/**
 * kafka消息生产者
 *
 * @author zgw 2019-07-25
 */
public interface IKafkaProducerService {

    /**
     * 默认的消息发送方法
     *
     * @param topic 主题
     * @param key   消息key
     * @param data  消息body
     */
    void defaultSendMessage(String topic, String key, Object data);

}
