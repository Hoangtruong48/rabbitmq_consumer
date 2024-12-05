package com.course.rabbitmq.htruong48.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/*
TODO : class này để
 - 1, tạo bean tự convert giữa object và json.
 - 2, Tạo thời gian nghỉ cho consumer và thời gian bật lại để nhận message
*/

@Configuration
@EnableScheduling
@EnableRabbit
public class RabbitMqConfig {

    @Bean
    ObjectMapper objectMapper() {
        return JsonMapper.builder().findAndAddModules().build();
    }

    @Bean
    Jackson2JsonMessageConverter converter(ObjectMapper objectMapper){
        return new Jackson2JsonMessageConverter(objectMapper);
    }
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;

    @Scheduled(cron = "0 26 19 * * *")
    public void stopAll() {
        rabbitListenerEndpointRegistry.getListenerContainers().forEach(Lifecycle::stop);
        log.info("Stop Success");
    }

    @Scheduled(cron = "0 27 19 * * *")
    public void startAll() {
        rabbitListenerEndpointRegistry.getListenerContainers().forEach(Lifecycle::start);
        log.info("Start Success");
    }


}
