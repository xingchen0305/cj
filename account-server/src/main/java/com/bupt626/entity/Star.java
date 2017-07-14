package com.bupt626.entity;

import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import java.util.Date;

/**
 * Created by i-hexiuyu on 2017/7/14.
 */
public class Star {
    private Date start_time;
    private String commodity_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Star)) return false;

        Star star = (Star) o;

        return getCommodity_id() != null ? getCommodity_id().equals(star.getCommodity_id()) : star.getCommodity_id() == null;
    }

    @Override
    public int hashCode() {
        return getCommodity_id() != null ? getCommodity_id().hashCode() : 0;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }
}
