package com.qydcos.be.controller;

import com.qydcos.be.entity.Account;
import com.qydcos.be.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by hexiuyu on 2017/6/15.
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/currentAccount")
    public Account currentAccount(Principal principal) {
        String username = principal.getName();
        Account account = accountRepository.findAccountInfoByUsername(username);
        return account;
    }

    @GetMapping("/currentAccount")
    public Account currentAccount(Principal principal) {
        String username = principal.getName();
        Account account = accountRepository.findAccountInfoByUsername(username);
        return account;
    }
}
