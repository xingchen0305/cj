package com.bupt626;

import com.bupt626.entity.Account;
import com.bupt626.entity.Star;
import com.bupt626.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServerApplicationTests {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void contextLoads() {
		Account account = new Account();
		account.setAccountName("hexiuyu");
		account.setAge(11);
		Star star = new Star();
		star.setStarTime(new Date());
		star.setCommodityId("dsfaf");
		star.setAccount(account);
		HashSet<Star> stars = new HashSet<>(Arrays.asList(star));
		account.setStars(stars);
		accountRepository.save(account);
	}

}
