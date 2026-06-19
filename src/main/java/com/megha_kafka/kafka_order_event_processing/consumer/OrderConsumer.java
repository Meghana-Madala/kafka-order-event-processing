package com.megha_kafka.kafka_order_event_processing.consumer;

import com.megha_kafka.kafka_order_event_processing.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(
            topics = "order-events",
            groupId = "order-processing-group")
    public void consume(Order order) {

        log.info("Received Order: {}", order.getOrderId());

        log.info("Validating Order...");

        log.info("Generating Invoice...");

        log.info("Order Processed Successfully");
    }
}