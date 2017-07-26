package com.bupt626.entity;

import com.bupt626.service.StarServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by CJ on 2017/7/22.
 */
@Component
@RabbitListener(queues = "cancel")
public class Receiver {
    @Autowired
    StarServiceImpl starServiceImpl;
    @RabbitHandler
    public void process(String id) {
        List<Star> stars=starServiceImpl.findByCommodityId(id);
        if(stars.size()>0) {
            for (Star star : stars) {
                star.setState("2");
                starServiceImpl.save(star);
            }
        }
        System.out.println("Receiver : " + id);
    }
}