package com.example.kafka.controller;

import com.example.kafka.dto.Customer;
import com.example.kafka.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            for (int i = 0; i < 100; i++) {
                publisher.sendMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("Message published successfully ...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }

    @PostMapping("/publish")
    public void sendEvents(@RequestBody Customer customer) {
        publisher.sendEventsToTopic(customer);
    }
}
