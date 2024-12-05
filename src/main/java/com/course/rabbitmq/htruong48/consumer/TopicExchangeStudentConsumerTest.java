package com.course.rabbitmq.htruong48.consumer;

import com.course.rabbitmq.htruong48.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.course.rabbitmq.htruong48.constant.RabbitMqName.*;

@Service
public class TopicExchangeStudentConsumerTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ObjectMapper objectMapper;
    @Autowired
    public TopicExchangeStudentConsumerTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @RabbitListener(queues = STUDENT_C1_QUEUE)
    public void receiveStudent(Student student) throws JsonProcessingException {
//        var student = objectMapper.readValue(message, Student.class);
//        if (student.getCapHoc().contains("LEVEL")){
//            throw new RuntimeException("Bắn ra ngoại lệ để test queue đưa vào DLT");
//        }
        log.info("Student cap 1 = {}", student);
    }
    @RabbitListener(queues = STUDENT_C2_QUEUE)
    public void receiveStudentCap2(Student student) throws JsonProcessingException {
//        var student = objectMapper.readValue(message, Student.class);
        log.info("Student cap 2 = {}", student);
    }
    @RabbitListener(queues = STUDENT_C3_QUEUE)
    public void receiveStudentCap3(Student student) throws JsonProcessingException {
//        var student = objectMapper.readValue(message, Student.class);
        log.info("Student cap 3 = {}", student);
    }
}
