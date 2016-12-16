package com.bupt626.controller;

import com.bupt626.domain.Demo;
import com.bupt626.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hexiuyu on 2016/12/16.
 */
@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;


    /**
     *<usage>
     *     http://localhost/testdemos
     *</usage>
     */
    @RequestMapping("testdemos")
    public List<Demo> getDemos(){
        return demoService.findAllDemo();
    }
}
