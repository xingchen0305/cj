package com.bupt626.domain;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by CJ on 2017/7/22.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void  send(String id) {
        System.out.println("Sender : " + id);
        this.rabbitTemplate.convertAndSend("cancel", id);
       // return context;
    }
}
