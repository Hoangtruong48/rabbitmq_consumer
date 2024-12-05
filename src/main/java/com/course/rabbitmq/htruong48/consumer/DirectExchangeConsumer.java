package com.course.rabbitmq.htruong48.consumer;

import com.course.rabbitmq.htruong48.entity.Image;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class DirectExchangeConsumer {
    private final ObjectMapper objectMapper;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

//    @Autowired
    public DirectExchangeConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @RabbitListener(queues = "x.png")
    public void receivePng(String message) throws JsonProcessingException {
        var image = objectMapper.readValue(message, Image.class);
        log.info("receive png image: {}", image);
    }
    @RabbitListener(queues = "x.jpg")
    public void receiveJpg(String message) throws JsonProcessingException {
        var image = objectMapper.readValue(message, Image.class);
        log.info("receive jpg image: {}", image);
    }
    @RabbitListener(queues = "x.vector")
    public void receiveVector(String message) throws JsonProcessingException {
        var image = objectMapper.readValue(message, Image.class);
        log.info("receive vector image: {}", image);
    }
}
