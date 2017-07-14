package com.bupt626.entity;


import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * Created by i-hexiuyu on 2017/7/14.
 */
public class Account {

    @Id
    private long id;
    private String accountName;
    private Integer age;
    private String sex;
    private Set<Address> addresses;
    private Set<Star> stars;


    public Account() {
    }

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public Account(String accountName, Integer age, String sex) {
        this.accountName = accountName;
        this.age = age;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
