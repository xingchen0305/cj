package com.bupt626.controller;

import com.bupt626.entity.Organization;
import com.bupt626.service.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bupt626.common.utils.MessageUtil.sendFailMessage;
import static com.bupt626.common.utils.MessageUtil.sendSuccessMessage;

/**
 * Created by CJ on 2017/6/18.
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationServiceImpl organizationService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Organization organization){
        organizationService.save(organization);
        return sendSuccessMessage();
    }
    @RequestMapping("/findById")
    public String findOne(String id){
        Organization organization = organizationService.findOne(id);
        if(organization!=null)
           return sendSuccessMessage(organization);
        else return sendFailMessage();
    }
    @RequestMapping("/getUserInfo")
    public String getUserInfo(){
        return "棒极了！哈哈";
    }
}
