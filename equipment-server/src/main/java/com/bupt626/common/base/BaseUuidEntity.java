package com.bupt626.common.base;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
/**
 * @author chzhao
 * @Title: UUIDBasePo.java
 * @Description: 基础的PO
 * @date 2017年6月7日 上午10:31:48
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseUuidEntity implements Serializable{

    /**
     * 主键ID
     * Hibernate3.6以后,UUIDHexGenerator(uuid)已不推荐使用，改用UUIDGenerator(org.hibernate
     * .id.UUIDGenerator)
     */
    @Expose
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String id;

    @Column(name= "CREATE_TIME")
    private Date createTime;

    @Column(name= "LAST_UPDATE")
    private Date lastUpdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 功能:get '创建时间'<br/>
     * date:  <br/>
     *
     * @author
     * @return
     */

    public Date getCreateTime(){
        return createTime;
    }


    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * 功能:get '更新时间'<br/>
     * date:  <br/>
     *
     * @author
     * @return
     */

    public Date getLastUpdate(){
        return lastUpdate;
    }


    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = lastUpdate;
    }

}
