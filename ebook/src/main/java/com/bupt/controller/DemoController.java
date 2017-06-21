package com.bupt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hexiuyu on 2017/4/11.
 */
@Controller
@RequestMapping("/demo")
//@PreAuthorize("hasRole('ADMIN')")
public class DemoController {

    @RequestMapping("")
    public @ResponseBody String demoPage(){
        return "demo";
    }

}
