package com.qydcos.be.vo;

import com.qydcos.be.entity.Authority;
import com.qydcos.be.entity.OAuthUser;
import com.qydcos.be.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by hexiuyu on 2017/6/14.
 */
public class UserInfo {
    private OAuthUser user;
    private List<Role> roles;
    private Set<Authority> authorities;

    public UserInfo() {
    }

    public UserInfo(OAuthUser user, List<Role> roles, List<Autowired> autowireds) {
        this.user = user;
        this.roles = roles;
        this.authorities = authorities;
    }

    public OAuthUser getUser() {
        return user;
    }

    public void setUser(OAuthUser user) {
        this.user = user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
