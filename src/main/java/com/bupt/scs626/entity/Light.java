package com.bupt.scs626.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by i-hexiuyu on 2017/7/17.
 */
@Entity
@Table(name = "account")
public class Light {
    @Id
    @Column(name = "login_name")
    private String loginName;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name= "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "last_update")
    private Date lastUpdate;

    @Column(name = "name")
    private String name;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String accountName) {
        this.loginName = accountName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Column(name = "role")
    private int role;

    public Light() {
    }

    public Light(Light account) {
        this.loginName = account.getLoginName();
        this.role = account.getRole();
        this.name = account.getName();
    }
}
