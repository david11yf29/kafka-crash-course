package com.example.kafka.service;

import com.example.kafka.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {
//        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("topic-par-2", 3,null,message);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                System.out.println("Sent Message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            } else {
//                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
//            }
//        });
        kafkaTemplate.send("topic-par-2", 3, null, "hi");
        kafkaTemplate.send("topic-par-2", 1, null, "hello");
        kafkaTemplate.send("topic-par-2", 2, null, "welcome");
        kafkaTemplate.send("topic-par-2", 2, null, "youtube");
        kafkaTemplate.send("topic-par-2", 0, null, "David");
    }

    public void sendEventsToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("topic-obj-1", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent Message=[" + customer.toString() + "] with offset=[" + result.getRecordMetadata().offset() +
                            "]");
                } else {
                    System.out.println("Unable to send message=[" + customer.toString() + "] due to : " + ex.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }

    }
}
