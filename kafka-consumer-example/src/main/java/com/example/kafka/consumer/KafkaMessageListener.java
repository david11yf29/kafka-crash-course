package com.example.kafka.consumer;

import com.example.kafka.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

//    @KafkaListener(topics = "topic-par-1", groupId = "group-par")
//    public void consumeEvents(Customer customer) {
//        log.info("Consumer consume the events: {}", customer.toString());
//
//    }

    @KafkaListener(topics = "topic-par-2", groupId = "group-par", topicPartitions = {@TopicPartition(topic = "topic" +
            "-par-2", partitions = {"2"})})
    public void consume2(String message) {
        log.info("Consumer2 consume the message: {}", message);

    }
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
