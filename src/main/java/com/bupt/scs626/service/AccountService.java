package com.bupt.scs626.service;


import com.bupt.scs626.entity.Account;
import com.bupt.scs626.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by i-hexiuyu on 2017/7/17.
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account findAccount(String loginName){
        return accountRepository.findOne(loginName);
    }

    public void save(Account account){
        accountRepository.save(account);
    }

}
