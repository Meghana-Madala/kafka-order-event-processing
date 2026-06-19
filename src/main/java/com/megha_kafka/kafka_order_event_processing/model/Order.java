package com.megha_kafka.kafka_order_event_processing.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long orderId;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Product is required")
    private String product;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @Min(value = 1, message = "Amount must be greater than 0")
    private Double amount;
}