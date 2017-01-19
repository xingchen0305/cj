package com.bupt626.controller;

import com.bupt626.domain.Demo;
import com.bupt626.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

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
     *     http://localhost:8080/testdemos
     *     if config security : enable resource server
     *     use:
     *          curl -H "Authorization: bearer [access_token]" localhost:8080/testdemos
     *     get the access_token ,see auth server
     *</usage>
     */

    /**
     * use @PreAuthorize("hasRole('ADMIN')")  mean that this api need role what is "ROLE_ADMIN"
     *
     */

    @RequestMapping("testdemos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Demo> getDemos(){
        return demoService.findAllDemo();
    }
}
