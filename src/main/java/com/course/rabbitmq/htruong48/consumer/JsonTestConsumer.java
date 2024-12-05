package com.course.rabbitmq.htruong48.consumer;

import com.course.rabbitmq.htruong48.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class JsonTestConsumer {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ObjectMapper objectMapper;

    public JsonTestConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "students-test")
    public void receive(String msg) throws JsonProcessingException {
        var a = objectMapper.readValue(msg, Student.class);
        log.info("Student = {}", a);
    }
}
