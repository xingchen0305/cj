package com.qydcos.be.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.oracle.tools.packager.Log;
import com.qydcos.be.entity.*;
import com.qydcos.be.vo.UserForm;
import com.qydcos.be.repository.UserRepository;
import com.qydcos.be.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@SessionAttributes("authorizationRequest")
public class UserApi {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/currentUser")
    public UserInfo currentUser(Principal user) {
        Log.info("UserApi get oauthUser: username = " + user.getName());
        OAuthUser currentUser = (OAuthUser) userRepository.findByUsername(user.getName()).get(0);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(currentUser);
        ArrayList<Role> roles = new ArrayList<>();
        Set<Authority> authorities = new HashSet<>();
        for (UserRole role : currentUser.getUserRoles()) {
            roles.add(role.getRole());
            for (RoleAuthority ra : role.getRole().getRoleAuthorities()) {
                authorities.add(ra.getAuthority());
            }
        }
        userInfo.setRoles(roles);
        userInfo.setAuthorities(authorities);
        return userInfo;
    }

    @GetMapping("/check-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String checkAdmin() {
        return "You are an admin";
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
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
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}
