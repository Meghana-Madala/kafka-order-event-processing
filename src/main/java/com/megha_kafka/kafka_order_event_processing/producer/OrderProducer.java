package com.megha_kafka.kafka_order_event_processing.producer;

import com.megha_kafka.kafka_order_event_processing.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private static final String TOPIC = "order-events";

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public void publishOrder(Order order) {

        kafkaTemplate.send(
                TOPIC,
                String.valueOf(order.getOrderId()),
                order);

        log.info(
                "Order Published: OrderId={}, Topic={}",
                order.getOrderId(),
                TOPIC);
    }
}