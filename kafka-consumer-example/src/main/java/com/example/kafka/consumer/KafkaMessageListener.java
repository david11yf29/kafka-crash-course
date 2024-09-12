package com.example.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "topic-1", groupId = "group")
    public void consume1(String message) {
        log.info("Consumer1 consume the message: {}", message);

    }

    @KafkaListener(topics = "topic-1", groupId = "group")
    public void consume2(String message) {
        log.info("Consumer2 consume the message: {}", message);

    }

    @KafkaListener(topics = "topic-1", groupId = "group")
    public void consume3(String message) {
        log.info("Consumer3 consume the message: {}", message);

    }

    @KafkaListener(topics = "topic-1", groupId = "group")
    public void consume4(String message) {
        log.info("Consumer4 consume the message: {}", message);

    }
}
