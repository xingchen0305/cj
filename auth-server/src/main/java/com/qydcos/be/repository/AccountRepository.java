package com.qydcos.be.repository;

import com.qydcos.be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by hexiuyu on 2017/6/15.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM account WHERE username = ?1 LIMIT 1", nativeQuery = true)
    Account findAccountInfoByUsername(String username);

}
