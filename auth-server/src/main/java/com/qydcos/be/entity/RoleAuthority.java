package com.qydcos.be.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_authorities")
public class    RoleAuthority implements Serializable {

    private static final long serialVersionUID = 8133285489854655043L;

    private Long id;
    private Role role;
    private Authority authority;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "auth_id")
    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
