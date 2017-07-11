package com.bupt626.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * Created by hexiuyu on 2017/6/25.
 */
@Configuration
public class OAuth2FeignClintConfiguration {
    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                               SecurityContext context = SecurityContextHolder.getContext();
                Authentication authentication = context.getAuthentication();
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();


                requestTemplate.header("Authorization", "bearer " + details.getTokenValue());
            }
        };
    }
}
