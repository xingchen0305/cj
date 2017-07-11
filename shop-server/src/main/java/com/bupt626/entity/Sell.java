package com.bupt626.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by i-hexiuyu on 2017/7/11.
 */
@Entity
@Table(name = "sell", schema = "shop", catalog = "")
public class Sell {
    private int sId;
    private BigDecimal sPrice;
    private Commodity commodity;

    @Id
    @Column(name = "S_ID")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "S_PRICE")
    public BigDecimal getsPrice() {
        return sPrice;
    }

    public void setsPrice(BigDecimal sPrice) {
        this.sPrice = sPrice;
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
