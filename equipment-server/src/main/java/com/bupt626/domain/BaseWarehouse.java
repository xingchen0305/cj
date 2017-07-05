package com.bupt626.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.util.Date;


/**
 * Created by mengying on 2017/6/17.
 */
@Entity
@Table(name = "base_warehouse")
public class BaseWarehouse  {
    private String id;
    private String name;
    private String location;
    private String username;
    private Date createTime;
    private Date lastUpdate;
    private String orgId;
    //游离态字段
    private String orgName;
    private String displayName;

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Column(name = "NAME")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    @Column(name = "LOCATION")
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }


    @Column(name = "USER_NAME")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name= "CREATE_TIME", updatable = false)
    public Date getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "LAST_UPDATE")
    public Date getLastUpdate(){
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "ORG_ID")
    public String getorgId() { return orgId; }
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Transient
    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }
    @Transient
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
}
