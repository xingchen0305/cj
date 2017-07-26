package com.bupt.domain;

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

    public String  send(int i) {
        String context = "shop " +i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
        return context;
    }
}
