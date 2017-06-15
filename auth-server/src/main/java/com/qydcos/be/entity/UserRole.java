package com.qydcos.be.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    private Long id;

    private OAuthUser user;
    private Role role;
    public UserRole(OAuthUser user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    public OAuthUser getUser() {
        return user;
    }

    public void setUser(OAuthUser user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name =  "role_id")
    @JsonIgnore
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
