package com.bupt626.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by i-hexiuyu on 2017/7/17.
 */
@Table(name = "star")
@Entity
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "commodity_id")
    private String commodityId;
    @Column(name = "startime")
    private Date starTime;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_name")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Star)) return false;

        Star star = (Star) o;

        return getCommodityId() != null ? getCommodityId().equals(star.getCommodityId()) : star.getCommodityId() == null;

    }

    @Override
    public int hashCode() {
        return getCommodityId() != null ? getCommodityId().hashCode() : 0;
    }
}
