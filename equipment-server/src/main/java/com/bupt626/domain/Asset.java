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
    private Integer property;//公有或私有
    private String count;
    private String code;
  //  private String location;
    private Integer state;
    private String warehouse_id;
    private String barcode;
    //游离态
    private String warehous_name;
    private String warehous_location;
    private String warehous_user_name;
    private String stateName;
    private String type;
    private String propertyName;
    //@Id,@GeneratedValue,@GenericGenerator. ,@GeneratedValue作用是JPA的默认实现自定义主键生成策略
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Temporal(TemporalType.TIMESTAMP)//指定映射数据库中的日期事件类型
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
    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
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


    /*@Basic
        @Column(name = "LOCATION")
        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    */
    @Basic
    @Column(name = "STATE")
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Basic
    @Column(name = "WAREHOUSE_ID")
    public String getWarehouse_id() {
        return warehouse_id;
    }
    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }
    @Basic
    @Column(name = "BARCODE")
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
    @Transient
    public String getStateName() {  return stateName;  }

    public void setStateName(String stateName) {  this.stateName = stateName;}
    @Transient
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Transient
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
