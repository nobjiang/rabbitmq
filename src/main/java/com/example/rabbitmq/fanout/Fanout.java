package com.example.rabbitmq.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmq
 * @description: fanout
 * @author: zhaoliang
 * @create: 2021-07-30 07:43
 **/
@RestController
public class Fanout {

    @Autowired
    private RabbitTemplate rabbitTemplate;

@GetMapping("fanout")
    public void testFanout() throws InterruptedException {
        rabbitTemplate.convertAndSend("logs","","这是日志广播");
    }
}
