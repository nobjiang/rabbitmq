package com.example.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    /**
    * @Description: 直连
    * @Param: []
    * @return: void
    * @Author: zhaoliang
    * @Date: 2021-07-30 07:22:19
    */
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }
    

    @Test
    /** 
    * @Description: 工作组 
    * @Param: [] 
    * @return: void 
    * @Author: zhaoliang
    * @Date: 2021-07-30 07:23:56 
    */ 
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello work!"+i);
        }
    }



    

}
