package com.course.rabbitmq.htruong48.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class HelloRabbitMqConsumer {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private static long count = 1;
    @RabbitListener(queues = "test", concurrency = "3-7")
    public void receiveMessage(String message) throws InterruptedException {
        LOG.info("count = {} : {}", count++, message);
        Thread.sleep(2000);
    }
}
