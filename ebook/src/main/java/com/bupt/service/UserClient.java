package com.bupt.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;

/**
 * Created by bupt626 on 2017/06/12.
 */
@FeignClient("equipment-server")
public interface UserClient {
    @RequestMapping(value="/equipments/getUserInfo", method= RequestMethod.GET)
    public String getUserInfo();
}
