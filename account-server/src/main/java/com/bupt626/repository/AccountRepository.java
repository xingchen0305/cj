package com.bupt626.repository;

import com.bupt626.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by i-hexiuyu on 2017/7/14.
 */

@Repository
public interface AccountRepository extends MongoRepository<Account,String>{
    public Account findByAccountName(String accountName);
}
