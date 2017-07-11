package com.bupt626.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by i-hexiuyu on 2017/7/11.
 */
@Entity
@Table(name = "rent", schema = "shop", catalog = "")
public class Rent {
    private int rId;
    private BigDecimal rPrice;
    private Commodity commodity;

    @Id
    @Column(name = "R_ID")
    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "R_PRICE")
    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    @OneToOne
    @JoinColumn(name = "C_ID")
    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
