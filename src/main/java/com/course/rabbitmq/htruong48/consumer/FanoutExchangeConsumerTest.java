package com.course.rabbitmq.htruong48.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class FanoutExchangeConsumerTest {
    private final ObjectMapper objectMapper;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
//    @Autowired
    public FanoutExchangeConsumerTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "x.marketing")
    public void receiveMarketing(String message) throws JsonProcessingException {
        var Human = objectMapper.readValue(message, com.course.rabbitmq.htruong48.entity.Human.class);
        log.info("Marketing: {}", Human);
    }
    @RabbitListener(queues = "x.accounting")
    public void receiveAccounting(String message) throws JsonProcessingException {
        var Human = objectMapper.readValue(message, com.course.rabbitmq.htruong48.entity.Human.class);
        log.info("Accounting: {}", Human);
    }
}
