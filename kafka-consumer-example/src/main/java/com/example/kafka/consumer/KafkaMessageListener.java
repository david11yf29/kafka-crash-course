package com.example.kafka.consumer;

import com.example.kafka.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "topic-obj-1", groupId = "group-obj")
    public void consumeEvents(Customer customer) {
        log.info("Consumer consume the events: {}", customer.toString());

    }

//    @KafkaListener(topics = "topic-1", groupId = "group")
//    public void consume2(String message) {
//        log.info("Consumer2 consume the message: {}", message);
//
//    }
//
//    @KafkaListener(topics = "topic-1", groupId = "group")
//    public void consume3(String message) {
//        log.info("Consumer3 consume the message: {}", message);
//
//    }
//
//    @KafkaListener(topics = "topic-1", groupId = "group")
//    public void consume4(String message) {
//        log.info("Consumer4 consume the message: {}", message);
//
//    }
}
