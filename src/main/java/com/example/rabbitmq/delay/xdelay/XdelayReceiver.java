package com.example.rabbitmq.delay.xdelay;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
@EnableRabbit
@Configuration
public class XdelayReceiver {

    @RabbitListener(queues ="X-Q")
    public void get(String msg) {
        System.out.println("Receive" + msg);
    }
}

