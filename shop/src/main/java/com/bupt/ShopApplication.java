package com.bupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableDiscoveryClient
@EnableFeignClients
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
