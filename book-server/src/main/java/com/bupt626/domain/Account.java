package com.bupt626.domain;

import java.io.Serializable;

/**
 * Created by hexiuyu on 2017/6/15.
 */


public class Account implements Serializable{


    private Long id;
    private String username;
    private String displayName;
    private int age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
