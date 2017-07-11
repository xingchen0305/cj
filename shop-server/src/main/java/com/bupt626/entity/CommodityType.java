package com.bupt626.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by i-hexiuyu on 2017/7/11.
 */
@Entity
@Table(name = "commodity_type", schema = "shop", catalog = "")
public class CommodityType {
    private int id;
    private String name;
    private String desc;
    private Set<CommodityExt> commodityExtSet;

    @Id
    @Column(name = "T_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "T_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "T_DESC")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @OneToMany(mappedBy = "commodityType")
    public Set<CommodityExt> getCommodityExtSet() {
        return commodityExtSet;
    }

    public void setCommodityExtSet(Set<CommodityExt> commodityExtSet) {
        this.commodityExtSet = commodityExtSet;
    }
}
