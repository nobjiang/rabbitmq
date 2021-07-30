package com.example.rabbitmq.drouting;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmq
 * @description: 动态路由
 * @author: zhaoliang
 * @create: 2021-07-30 11:10
 **/
@RestController
public class DRouting {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("drouting")
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save.findAll","user.save.findAll 的消息");
    }
}
