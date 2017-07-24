package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ycliu
 * @Title: Commodity
 * @Description:
 * @date 2017/07/22 15:22:00
 */
@Entity
@Table(name = "commodity")
public class Commodity {
   //商品信息
    private String id;
    private String name;
    private String owner;
    private String assetId;
    private String infoId;
    private String businessType;
    private int commodityStatus;

    //业务出租信息
    private BigDecimal deposit;
    private BigDecimal rent;
    private BigDecimal damages;
    private int rentStatus;
    private Date startTime;
    private Date endTime;

    //业务出售信息
    //业务易物信息

    private Date createTime;
    private Date lastUpdate;

    private Book book;


    @Id
    @Column(name = "C_ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name= "C_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name= "C_OWNER")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    @Column(name= "ASSET_ID")
    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
    @Column(name= "C_INFO_ID")
    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }
    @Column(name= "BUSINESS_TYPE")
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Column(name= "C_STATUS")
    public int getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(int commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    //出租信息
    @Column(name= "R_DEPOSIT")
    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    @Column(name= "R_RENT")
    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    @Column(name= "R_DAMAGES")
    public BigDecimal getDamages() {
        return damages;
    }

    public void setDamages(BigDecimal damages) {
        this.damages = damages;
    }

    @Column(name= "R_STATUS")
    public int getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(int rentStatus) {
        this.rentStatus = rentStatus;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "R_START_TIME")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "R_END_TIME")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Temporal(TemporalType.TIMESTAMP)//指定映射数据库中的日期事件类型
    @CreationTimestamp
    @Column(name= "CREATE_TIME", updatable = false )
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Transient
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
