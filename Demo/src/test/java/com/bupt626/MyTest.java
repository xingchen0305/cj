package com.bupt626;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by hexiuyu on 2017/2/28.
 */
public class MyTest {

    @Test
    public void demoTest(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("bupt626"));
        System.out.println(passwordEncoder.matches("123456", "$2a$10$hTGtbco/ZqgvosoQVWdOdeKYBcJSspdPpVtfqyF7uUUBVz0UtBXWy"));
    }

}
