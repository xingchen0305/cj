package com.bupt626.service;

import com.bupt626.domain.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by hexiuyu on 2017/6/14.
 */
@FeignClient(name = "user", url = "http://10.105.242.74:9999")
public interface UserClient {
    @RequestMapping(value="/uaa/account/currentAccount", method= RequestMethod.GET)
    public Account currentAccount();
}