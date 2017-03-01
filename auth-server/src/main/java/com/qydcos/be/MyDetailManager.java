package com.qydcos.be;

import com.qydcos.be.entity.OAuthUser;
import com.qydcos.be.entity.Role;
import com.qydcos.be.entity.UserRole;
import com.qydcos.be.repository.RoleRepository;
import com.qydcos.be.repository.UserRepository;
import com.qydcos.be.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexiuyu on 2017/2/28.
 */
public class MyDetailManager extends JdbcUserDetailsManager {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    String authoritiesByUsernameQuery = "";

    private static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
            "select r.code from user_role ur\n" +
                    "left join users u on u.id = ur.user_id\n" +
                    "left join role r on r.id = ur.role_id\n" +
                    "where u.username = ?\n" +
                    "union\n" +
                    "select a.code from role_authorities ra\n" +
                    "left join authorities a on a.id = ra.auth_id\n" +
                    "left join user_role ur on ur.role_id = ra.role_id\n" +
                    "left join users u on u.id = ur.user_id\n" +
                    "where u.username = ?";

    public MyDetailManager() {
        this.authoritiesByUsernameQuery = DEF_AUTHORITIES_BY_USERNAME_QUERY;
    }

    @Override
    protected List<GrantedAuthority> loadUserAuthorities(String username) {
        return getJdbcTemplate().query(this.authoritiesByUsernameQuery,
                new String[] { username, username }, new RowMapper<GrantedAuthority>() {
                    public GrantedAuthority mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        String roleName =  getRolePrefix()+ rs.getString(1);
                        return new SimpleGrantedAuthority(roleName);
                    }
                });
    }

    @Override
    @Transactional
    public void createUser(UserDetails user) {
        if (user instanceof OAuthUser) {
            OAuthUser oAuthUser = (OAuthUser) user;

            List<Role> defaultRoles = roleRepository.findByCodeIn("ROLE_USER");
            List<UserRole> userRoles = new ArrayList<>();
            defaultRoles.stream()
                    .map((role) -> new UserRole(oAuthUser, role))
                    .forEach(userRoles::add);

            userRepository.save(oAuthUser);
            userRoleRepository.save(userRoles);
        }
    }


    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {

        List<UserDetails> userDetailsList = userRepository.findByUsername(username);

        return userDetailsList;

    }

}
