# Kafka Order Event Processing

## Overview

Kafka Order Event Processing is a Spring Boot microservice that demonstrates event-driven architecture using Apache Kafka. The application accepts order requests through a REST API, publishes order events to Kafka topics, and processes those events asynchronously using Kafka consumers.

This project showcases:

* Apache Kafka Producer and Consumer
* Spring Boot REST APIs
* Event-Driven Architecture
* JSON Serialization and Deserialization
* Kafka Topic Management
* Input Validation and Error Handling
* Dockerized Kafka Infrastructure
* Kafka UI Monitoring

---

## Architecture

```text
Client (Postman)
        |
        v
REST API (/orders)
        |
        v
Kafka Producer
        |
        v
Kafka Topic (order-events)
        |
        v
Kafka Consumer
        |
        v
Order Processing
    - Validation
    - Invoice Generation
    - Processing Logs
```

---

## Tech Stack

### Backend

* Java 17
* Spring Boot 3
* Spring Kafka
* Spring Validation
* Lombok

### Messaging

* Apache Kafka
* ZooKeeper

### DevOps

* Docker
* Docker Compose

### Monitoring

* Kafka UI

### Testing

* Postman

---

## Project Structure

```text
src/main/java
│
├── config
│   └── KafkaConfig.java
│
├── controller
│   └── OrderController.java
│
├── consumer
│   └── OrderConsumer.java
│
├── producer
│   └── OrderProducer.java
│
├── model
│   └── Order.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
└── KafkaOrderEventProcessingApplication.java
```

---

## Order Model

```json
{
  "orderId": 1001,
  "customerName": "Rajesh",
  "product": "Laptop",
  "quantity": 1,
  "amount": 75000
}
```

Validation Rules:

* orderId must be present
* customerName cannot be blank
* product cannot be blank
* quantity must be greater than 0
* amount must be greater than 0

---

## Kafka Infrastructure

### Start Kafka

```bash
docker compose up -d
```

Verify containers:

```bash
docker ps
```

Expected Containers:

```text
kafka
zookeeper
kafka-ui
```

---

## Kafka Topic

Topic Name:

```text
order-events
```

Current Configuration:

```text
Partitions: 3
Replication Factor: 1
```

Verify Topic:

```bash
docker exec -it kafka bash

kafka-topics \
--describe \
--topic order-events \
--bootstrap-server localhost:9092
```

---

## Running the Application

Compile:

```bash
mvn clean compile
```

Run:

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

## REST API

### Publish Order Event

Endpoint:

```http
POST /orders
```

URL:

```text
http://localhost:8080/orders
```

Request Body:

```json
{
  "orderId": 1001,
  "customerName": "Rajesh",
  "product": "Laptop",
  "quantity": 1,
  "amount": 75000
}
```

Response:

```json
{
  "message": "Order event published successfully"
}
```

---

## Validation Example

Invalid Request:

```json
{
  "orderId": 9999,
  "customerName": "Test",
  "product": "Laptop",
  "quantity": 0,
  "amount": 750
}
```

Response:

```http
400 Bad Request
```

---

## Kafka Consumer Processing

When an order is received, the consumer performs:

1. Order Validation
2. Invoice Generation Simulation
3. Order Processing

Sample Logs:

```text
Order Published: OrderId=1001, Topic=order-events

Received Order: 1001
Validating Order...
Generating Invoice...
Order Processed Successfully
```

---

## Kafka UI

Kafka UI provides a web interface to monitor:

* Topics
* Partitions
* Messages
* Consumer Groups
* Brokers

Access:

```text
http://localhost:8081
```

Features Demonstrated:

* View topic metadata
* Inspect messages
* Monitor partitions
* Observe consumer groups
* Verify message distribution

---

## Message Distribution

The project demonstrates Kafka partitioning.

Example:

```text
Partition 0 -> Messages
Partition 1 -> Messages
Partition 2 -> Messages
```

Kafka distributes records based on message keys and hashing strategy.

---

## Key Learning Outcomes

* Event-Driven Architecture
* Apache Kafka Fundamentals
* Producer-Consumer Pattern
* Topic Partitioning
* Consumer Groups
* Message Serialization
* Spring Boot Integration
* Dockerized Development Environment
* Error Handling and Validation

---

## Future Enhancements

* Retry Mechanism
* Dead Letter Topics (DLT)
* Database Integration
* Kafka Streams Processing
* Avro Serialization
* Schema Registry
* Distributed Consumers
* Kubernetes Deployment
* Observability with Prometheus and Grafana

---

## Author

Meghana Madala

```
```
