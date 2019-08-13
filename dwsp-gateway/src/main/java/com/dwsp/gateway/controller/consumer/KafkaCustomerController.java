//package com.dwsp.gateway.controller.consumer;
//
//import com.dwsp.customer.api.dto.CustomerStuDto;
//import com.dwsp.kafka.producer.IKafkaProducerService;
//import com.dwsp.kafka.producer.constant.KafkaTopicConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/kafka")
//public class KafkaCustomerController {
//
//    @Autowired
//    private IKafkaProducerService kafkaProducerService;
//
//    @RequestMapping("/test")
//    public String sendMessage() {
//        for (int i = 1; i < 20; i++) {
//            CustomerStuDto customerStuDto = new CustomerStuDto(Long.valueOf(i), "kafa", i + 20, "M", "10010");
//            kafkaProducerService.defaultSendMessage(KafkaTopicConstant.CONSUMER_TOPIC, "consumer" + i, customerStuDto);
//        }
//        return "success";
//    }
//}
