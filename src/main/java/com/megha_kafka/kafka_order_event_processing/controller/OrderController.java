package com.megha_kafka.kafka_order_event_processing.controller;

import com.megha_kafka.kafka_order_event_processing.model.Order;
import com.megha_kafka.kafka_order_event_processing.producer.OrderProducer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<Map<String, String>> createOrder(
            @Valid @RequestBody Order order) {

        orderProducer.publishOrder(order);

        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "Order event published successfully"));
    }
}