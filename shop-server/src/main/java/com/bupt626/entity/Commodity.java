package com.bupt626.entity;

import javax.persistence.*;

/**
 * Created by i-hexiuyu on 2017/7/11.
 */
@Entity
@Table(name = "commodity", schema = "shop", catalog = "")
public class Commodity {
    private int cId;
    private String cName;
    private String cOwner;
    private String assetId;
    private String cExt;
    // 手动判断
    private int tId;

    @Id
    @Column(name = "C_ID")
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "C_NAME")
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "C_OWNER")
    public String getcOwner() {
        return cOwner;
    }

    public void setcOwner(String cOwner) {
        this.cOwner = cOwner;
    }

    @Basic
    @Column(name = "ASSET_ID")
    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    @Basic
    @Column(name = "C_EXT")
    public String getcExt() {
        return cExt;
    }

    public void setcExt(String cExt) {
        this.cExt = cExt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commodity that = (Commodity) o;

        if (cId != that.cId) return false;
        if (cName != null ? !cName.equals(that.cName) : that.cName != null) return false;
        if (cOwner != null ? !cOwner.equals(that.cOwner) : that.cOwner != null) return false;
        if (assetId != null ? !assetId.equals(that.assetId) : that.assetId != null) return false;
        if (cExt != null ? !cExt.equals(that.cExt) : that.cExt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId;
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + (cOwner != null ? cOwner.hashCode() : 0);
        result = 31 * result + (assetId != null ? assetId.hashCode() : 0);
        result = 31 * result + (cExt != null ? cExt.hashCode() : 0);
        return result;
    }
}
