package com.bupt626.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Xtj on 2017/6/18.
 */
@Entity
@Table(name = "base_asset")
public class Asset {
    private String id;
    private Date createTime;
    private Date lastUpdate;
    private String name;
    private String property;//公有或私有
    private String count;
    private String location;
    private String state;
    private String type;
    private String warehouse_id;

    //游离态
    private String warehous_name;
    private String warehous_location;
    private String warehous_user_name;

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name= "CREATE_TIME", updatable = false )
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
    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PROPERTY")
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Basic
    @Column(name = "COUNT")
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Basic
    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Basic
    @Column(name = "WAREHOUSE_ID")
    public String getWarehouse_id() {
        return warehouse_id;
    }
    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }



    @Transient
    public String getWarehous_name() {
        return warehous_name;
    }

    public void setWarehous_name(String warehous_name) {
        this.warehous_name = warehous_name;
    }
    @Transient
    public String getWarehous_location() {
        return warehous_location;
    }

    public void setWarehous_location(String warehous_location) {
        this.warehous_location = warehous_location;
    }
    @Transient
    public String getWarehous_user_name() {
        return warehous_user_name;
    }

    public void setWarehous_user_name(String warehous_user_name) {
        this.warehous_user_name = warehous_user_name;
    }
}
