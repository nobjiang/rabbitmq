package com.example.rabbitmq.delay;

import com.example.rabbitmq.config.Config;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生产者生产消息
 * @author v-zhaoliang
 */
@Component
public class ImmediateSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg, int delayTime) {
        System.out.println("msg=" + ",delayTime" + delayTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rabbitTemplate.convertAndSend(Config.DEAD_LETTER_EXCHANGE, Config.DELAY_ROUTING_KEY, msg, message -> {
            message.getMessageProperties().setExpiration(delayTime + "");
            System.out.println(sdf.format(new Date()) + " Delay sent.");
            return message;
        });
    }

}