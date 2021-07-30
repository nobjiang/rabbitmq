package com.example.rabbitmq;

import com.example.rabbitmq.delay.ImmediateSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    ImmediateSender immediateSender;

    @Test
    public void test() {
        immediateSender.send("我是一个延时消息", 3000);//3秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
}

    @Test
    public void test1() {
        immediateSender.send("我是一个延时消息，睡10秒",10000);//10秒
        immediateSender.send("我是一个延时消息，睡2秒",2000);//2秒
        immediateSender.send("我是一个延时消息，睡1秒",1000);//1秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    

}
