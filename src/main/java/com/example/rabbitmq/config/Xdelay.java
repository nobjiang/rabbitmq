package com.example.rabbitmq.config;

/**
 * @program: rabbitmq
 * @description: x-delay
 * @author: zhaoliang
 * @create: 2021-07-30 17:06
 **/

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Xdelay {

    // 创建一个立即消费队列
    @Bean
    public Queue immediateQueue1() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue("X-Q", true);
    }

    @Bean
    public CustomExchange delayExchange2() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange("X-E", "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding bindingNotify() {
        return BindingBuilder.bind(immediateQueue1()).to(delayExchange2()).with("X-R").noargs();
    }
}