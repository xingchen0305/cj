package com.bupt626.domain;

import com.bupt626.common.BaseUuidEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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
    private Date createTime;
    private Date lastUpdate;

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
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
