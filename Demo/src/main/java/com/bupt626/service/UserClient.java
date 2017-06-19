package com.bupt626.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by hexiuyu on 2017/6/14.
 */
@FeignClient("auth")
public interface UserClient {
    @RequestMapping(value="/uaa/testRPCWithToken", method= RequestMethod.GET)
    public String getRPCWithToken();
}