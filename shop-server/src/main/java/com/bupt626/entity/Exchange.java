package com.bupt626.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by i-hexiuyu on 2017/7/11.
 */
@Entity
@Table(name = "exchange", schema = "shop", catalog = "")
public class Exchange {
    private int eId;
    private BigDecimal eValue;
    private Commodity commodity;

    @Id
    @Column(name = "E_ID")
    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "E_VALUE")
    public BigDecimal geteValue() {
        return eValue;
    }

    public void seteValue(BigDecimal eValue) {
        this.eValue = eValue;
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
