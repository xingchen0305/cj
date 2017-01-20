package com.bupt626;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class EquipmentServerApplication extends WebSecurityConfigurerAdapter {

	/**
	 * Option method will send before get or other methods, cause it will check if it support csrf. It was
	 * sent by browser, So will should let Option method go without authentication
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers(HttpMethod.OPTIONS, "**");
	}

	public static void main(String[] args) {
		SpringApplication.run(EquipmentServerApplication.class, args);
	}
}
