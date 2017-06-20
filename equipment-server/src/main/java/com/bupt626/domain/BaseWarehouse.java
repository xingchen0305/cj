package com.bupt626.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mengying on 2017/6/17.
 */
@Entity
@Table(name = "base_warehouse")
public class BaseWarehouse {
    private String id;
    private String name;
    private String location;
    private String username;
    private Timestamp createTime;
    private Timestamp lastUpdate;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "ID")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Basic
    @Column(name = "LOCATION")
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Basic
    @Column(name = "USER_NAME")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "LAST_UPDATE")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
