package com.bupt.domain;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by bupt626 on 2017/06/14.
 */
@Entity
@Table(name = "central_library")
public class CentralLibrary  {
    private String id;
    private String douBanJson;
    private String juHeJson;
    private Date createTime;
    private Date lastUpdate;

    @Id
    @Column(name = "ISBN", updatable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "DOUBAN_JSON")
    public String getDouBanJson() {
        return douBanJson;
    }

    public void setDouBanJson(String douBanJson) {
        this.douBanJson = douBanJson;
    }

    @Column(name = "JUHE_JSON")
    public String getJuHeJson() {
        return juHeJson;
    }

    public void setJuHeJson(String juHeJson) {
        this.juHeJson = juHeJson;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "CREATE_TIME",updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
