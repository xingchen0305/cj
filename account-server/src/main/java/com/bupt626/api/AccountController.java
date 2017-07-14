package com.bupt626.api;

import com.bupt626.entity.Account;
import com.bupt626.entity.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by i-hexiuyu on 2017/7/14.
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 新增，修改
     *
     * @param account
     * @return
     */
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity createOrUpdateAccount(@RequestBody Account account) {
        try {
            accountService.saveAccount(account);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 获取自己的账户信息
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getOwnAccount() {
        String username = "张囡";
        return Optional.ofNullable(accountService.getAccountByUser(username))
                .map(account -> new ResponseEntity(account, HttpStatus.OK))
                .orElse(new ResponseEntity("no account with name :" + username, HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(value = "/star/{commodity_id}", method = RequestMethod.PUT)
    public ResponseEntity star(@PathVariable("commodity_id") String commodityId) {
        String username = "hexiuyuaasdfssa";
        Star star = new Star();
        star.setCommodity_id(commodityId);
        star.setStart_time(new Date());
        Account account = accountService.getAccountByUser(username);
        if (account == null) {
            Account newAccount = new Account(username);
            HashSet<Star> stars = new HashSet<>(Arrays.asList(star));
            newAccount.setStars(stars);
        } else {
            if (account.getStars() == null) {
                account.setStars(new HashSet<Star>(Arrays.asList(star)));
            } else {
                account.getStars().add(star);
            }
        }
        accountService.saveAccount(account);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
