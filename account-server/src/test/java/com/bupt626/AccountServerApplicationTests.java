package com.bupt626;

import com.bupt626.entity.Account;
import com.bupt626.entity.Address;
import com.bupt626.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServerApplicationTests {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	public void contextLoads() {
//		Account account = new Account("hexiuyuaasdfssa",11,"男");
//        Address address = new Address();
//        address.setCountry("中国");
//        address.setCity("aa");
//        Set<Address> addresses = new HashSet<>();
//        Address address2 = new Address();
//        address2.setCity("dafafdasf");
//        addresses.add(address);
//        addresses.add(address2)
//        account.setAddresses(addresses);

//        accountRepository.save(account);

        Account account = accountRepository.findByAccountName("hexiuyuaasdfssa");
        System.out.println(account);

	}


}
