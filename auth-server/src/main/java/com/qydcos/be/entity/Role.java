package com.qydcos.be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Role implements Serializable {

    private static final long serialVersionUID = -6395121219493110352L;

    private Long id;
    private String code;
    private String name;
    private String remark;

    private List<RoleAuthority> roleAuthorities = new ArrayList<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    public List<RoleAuthority> getRoleAuthorities() {
        return roleAuthorities;
    }

    public void setRoleAuthorities(List<RoleAuthority> roleAuthorities) {
        this.roleAuthorities = roleAuthorities;
    }
}
