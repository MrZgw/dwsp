package com.dwsp.kafka.producer.config;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class KafkaJsonDeserializer implements Deserializer {

    private String encoding = "UTF8";

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return JSON.parse(bytes);
    }

    @Override
    public void close() {

    }
}
