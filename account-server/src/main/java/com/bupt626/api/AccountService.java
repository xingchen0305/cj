package com.bupt626.api;

import com.bupt626.entity.Account;
import com.bupt626.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

/**
 * Created by i-hexiuyu on 2017/7/14.
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account){
        Account newAccount = accountRepository.save(account);
        return newAccount;
    }

    public Account getAccountByUser(String username){
        return accountRepository.findByAccountName(username);
    }
}
