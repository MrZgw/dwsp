package com.dwsp.kafka.producer.config;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class KafkaJsonSerializer implements Serializer {

    private String encoding = "UTF8";

    @Override
    public void configure(Map configs, boolean isKey) {
        String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if (encodingValue == null) {
            encodingValue = configs.get("serializer.encoding");
        }

        if (encodingValue instanceof String) {
            this.encoding = (String) encodingValue;
        }
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return JSON.toJSONBytes(data);
    }

    @Override
    public void close() {

    }
}
