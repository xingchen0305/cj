package com.bupt626.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Xtj on 2017/7/11.
 */
@Entity
@Table(name = "base_book")
public class Book {
    private String id;
    private Date createTime;
    private Date lastUpdate;
    private int type;
    private String topic;
    private String author;
    private String name;
    private String price;
    private String doubanJson;
    private String grade;
    private String coverUrl;
    private String press;
    private String description;

    //游离态
    private String typeName;
    //出租
    private String rent;
    private String  deposit;
    //出售
    private Double salePrice;
    private String saleWay;
    //以物易物
    private String wanted;
    private String remark;


    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Basic
    @Column(name = "CREATE_TIME")
    public Date getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "LAST_UPDATE")
    public Date getLastUpdate(){
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = lastUpdate;
    }
    @Basic
    @Column(name = "Type")

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Basic
    @Column(name = "TOPIC")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    @Basic
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "PRICE")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Basic
    @Column(name = "DOUBAN_JSON")
    public String getDoubanJson() {
        return doubanJson;
    }

    public void setDoubanJson(String doubanJson) {
        this.doubanJson = doubanJson;
    }
    @Basic
    @Column(name = "GRADE")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Basic
    @Column(name = "COVER_URL")
    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
    @Basic
    @Column(name = "PRESS")
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }
    @Transient
    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
    @Transient
    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }



    @Transient
    public String getSaleWay() {
        return saleWay;
    }

    public void setSaleWay(String saleWay) {
        this.saleWay = saleWay;
    }
    @Transient
    public String getWanted() {
        return wanted;
    }

    public void setWanted(String wanted) {
        this.wanted = wanted;
    }
    @Transient
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Transient
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
