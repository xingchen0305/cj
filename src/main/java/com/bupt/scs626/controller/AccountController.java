package com.bupt.scs626.controller;

import com.bupt.scs626.entity.Account;
import com.bupt.scs626.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bupt.scs626.common.MessageUtil.sendFailMessage;
import static com.bupt.scs626.common.MessageUtil.sendSuccessMessage;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/find/{id}",method= RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String loginName){
        Account account = accountService.findAccount(loginName);
        if(account!=null)
            return sendSuccessMessage(account);
        else return sendFailMessage();
    }
    @RequestMapping(value = "/saveOrUpdate",method= RequestMethod.POST)
    public String saveOrUpdate(@RequestBody Account account){
        accountService.save(account);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "/test",method= RequestMethod.GET)
    public String test(){

        return "chenggong";
    }

}
