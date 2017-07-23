package com.bupt.controller;

import com.bupt.domain.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CJ on 2017/7/22.
 */
@RestController
@RequestMapping("/rb")
public class RabbitTest {
    @Autowired
    private Sender sender;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return sender.send(12);
    }

}
