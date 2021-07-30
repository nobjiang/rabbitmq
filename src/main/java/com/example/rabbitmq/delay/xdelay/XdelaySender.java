package com.example.rabbitmq.delay.xdelay;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XdelaySender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg, int delayTime) {
        System.out.println("delayTime" + delayTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.rabbitTemplate.convertAndSend("X-E", "X-R", msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay(delayTime);
                System.out.println(sdf.format(new Date()) + " Delay sent.");
                return message;
            }
        });
    }
}

