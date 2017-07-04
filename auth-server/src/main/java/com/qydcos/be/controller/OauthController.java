package com.qydcos.be.controller;

import com.qydcos.be.entity.OAuthUser;
import com.qydcos.be.repository.UserRepository;
import com.qydcos.be.vo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@SessionAttributes("authorizationRequest")
public class OauthController {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired UserRepository userRepository;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/check-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String checkAdmin() {
        return "You are an admin";
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserForm user) {
        try {
            if (!StringUtils.hasText(user.getUsername())) {
                throw new Exception("username can not be empty");
            }

            if (!StringUtils.hasText(user.getPassword())) {
                throw new Exception("password can not be empty");
            }

            int count = userRepository.countByUsername(user.getUsername());
            if (count > 0) {
                throw new Exception("username already exists");
            }

            if (!user.isPasswordHashed()) {
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
            }

            OAuthUser oauthUser = new OAuthUser(user.getUsername(), user.getPassword());
            oauthUser.setEnabled(user.isEnabled());
            jdbcUserDetailsManager.createUser(oauthUser);
        } catch (Exception e) {
            Map<String, Object> result = new LinkedHashMap<>();
            result.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/oauth/revoke-token")
    public ResponseEntity logout(Principal principal){
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        OAuth2AccessToken accessToken = authorizationServerTokenServices.getAccessToken(oAuth2Authentication);
        consumerTokenServices.revokeToken(accessToken.getValue());
        return new ResponseEntity(HttpStatus.OK);
    }

}
