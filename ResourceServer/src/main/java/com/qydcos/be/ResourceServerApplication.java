package com.qydcos.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * curl -H "Authorization: bearer [access_token]" localhost:8081/flights/1
 */
@SpringBootApplication
@EnableResourceServer
public class ResourceServerApplication extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/flights/**").authorizeRequests().anyRequest().authenticated();
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
}
