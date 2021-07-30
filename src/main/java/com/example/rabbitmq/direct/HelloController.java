package com.example.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmq
 * @description: direct
 * @author: zhaoliang
 * @create: 2021-07-30 10:15
 **/
@RestController
public class HelloController {
    @Autowired
    AmqpTemplate rabbitTemplate;

    @GetMapping("direct")
    public void testHello(){

        rabbitTemplate.convertAndSend("hello","hello world");
    }



}
