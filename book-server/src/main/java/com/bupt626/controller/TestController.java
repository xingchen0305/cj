package com.bupt626.controller;


import com.bupt626.domain.Asset;
import com.bupt626.service.EquipmentClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hexiuyu on 2017/7/10.
 */

@RestController
public class TestController {

    @Autowired
    private EquipmentClient equipmentClient;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        Asset asset = equipmentClient.findById("1");

        return asset.getCount();
    }
}
