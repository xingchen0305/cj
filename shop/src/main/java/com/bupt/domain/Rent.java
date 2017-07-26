package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ycliu
 * @Title: Rent
 * @Description:
 * @date 2017/07/21 22:28:45
 */
@Entity
@Table(name = "rent")
public class Rent {
    private String id;
    private BigDecimal deposit;
    private BigDecimal rent;
    private BigDecimal damages;
    private int status;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Date lastUpdate;

    @Id
    @Column(name = "R_ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
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
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
