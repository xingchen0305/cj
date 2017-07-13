package com.bupt626.domain;
import com.bupt626.common.base.BaseUuidEntity;

import javax.persistence.*;

/**
 * Created by CJ on 2017/6/18.
 */
@Entity
@Table(name = "base_organization")
public class Organization extends BaseUuidEntity {

  //  private String id;
    private String superior;
    private String name;
    private Integer level;
  //  private Timestamp createTime;
  //  private Date updateTime;

    /*@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="ID", nullable = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }*/

    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "LEVEL")
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "SUPERIOR")
    public String getSuperior() {
        return superior;
    }
    public void setSuperior(String superior) {
        this.superior = superior;
    }

   /* @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

   // @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }*/


    public Organization() {
    }

    public Organization(Organization organization) {
        this.id = organization.getId();
        this.superior = organization.getSuperior();
        this.name = organization.getName();
        this.level = organization.getLevel();
       // this.createTime = organization.getCreateTime();
       // this.updateTime = organization.getUpdateTime();
    }
}
