package com.example.rabbitmq.routing;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: rabbitmq
 * @description: routing
 * @author: zhaoliang
 * @create: 2021-07-30 10:26
 **/
@RestController
public class RoutingController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("routing")
    public void testDirect(){

        rabbitTemplate.convertAndSend("directs","error","error 的日志信息");

    }
}
