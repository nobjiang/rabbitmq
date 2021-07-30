package com.example.rabbitmq.group;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmq
 * @description: Group
 * @author: zhaoliang
 * @create: 2021-07-30 07:30
 **/
@RestController
public class GroupController {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("work")
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello work!"+i);
        }
    }
}
