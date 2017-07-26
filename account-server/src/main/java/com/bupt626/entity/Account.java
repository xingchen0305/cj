package com.bupt626.entity;


import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by i-hexiuyu on 2017/7/17.
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_name")
    private String accountName;

    private String sex;
    private Integer age;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private Set<Address> addresses;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private Set<Star> stars;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Star> getStars() {
        return stars;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
    }
}
