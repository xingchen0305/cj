package com.qydcos.be.web;

import com.qydcos.be.entity.OAuthUser;
import com.qydcos.be.entity.UserRole;
import com.qydcos.be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
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

    @GetMapping("/userInfo")
    public OAuthUser userInfo() {
        return new OAuthUser("test", "aaa");
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

    private static class UserForm {
        private String password;
        private String username;
        private boolean accountNonExpired = true;
        private boolean accountNonLocked = true;
        private boolean credentialsNonExpired = true;
        private boolean enabled = true;

        private boolean passwordHashed = false;


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isAccountNonExpired() {
            return accountNonExpired;
        }

        public void setAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
        }

        public boolean isAccountNonLocked() {
            return accountNonLocked;
        }

        public void setAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
        }

        public boolean isCredentialsNonExpired() {
            return credentialsNonExpired;
        }

        public void setCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public boolean isPasswordHashed() {
            return passwordHashed;
        }

        public void setPasswordHashed(boolean passwordHashed) {
            this.passwordHashed = passwordHashed;
        }
    }
}
