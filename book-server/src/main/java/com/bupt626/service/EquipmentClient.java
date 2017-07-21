package com.bupt626.service;

import com.bupt626.domain.Asset;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hexiuyu on 2017/7/10.
 */

@FeignClient(name = "asset", url = "http://127.0.0.1:8755")
public interface EquipmentClient {

    @RequestMapping(value="/asset/find/{id}", method= RequestMethod.GET)
    public Asset findById(@PathVariable(value="id") String id);
}

