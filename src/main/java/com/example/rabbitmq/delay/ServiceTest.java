package com.example.rabbitmq.delay;

import com.example.rabbitmq.delay.xdelay.XdelaySender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: rabbitmq
 * @description: test
 * @author: zhaoliang
 * @create: 2021-07-30 16:37
 **/
@RestController
public class ServiceTest {
    @Autowired
    ImmediateSender immediateSender;

    @Autowired
    XdelaySender xdelaySender;

    @GetMapping("test")
    public void send(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("发送延时消息时间："+sdf.format(new Date()) + " Delay sent.");
        immediateSender.send("我是一个延时消息，睡10秒",10000);
        immediateSender.send("我是一个延时消息，睡2秒",2000);
        immediateSender.send("我是一个延时消息，睡1秒",1000);
    }


    @GetMapping("xdelay")
    public void sender(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("发送延时消息时间："+sdf.format(new Date()) + " Delay sent.");
        xdelaySender.send("我是一个延时消息，睡10秒",10000);
        xdelaySender.send("我是一个延时消息，睡2秒",2000);
        xdelaySender.send("我是一个延时消息，睡1秒",1000);
    }

}
