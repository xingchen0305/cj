package com.bupt.domain;

import com.bupt.common.base.BaseUuidEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ycliu
 * @Title: BookInfo
 * @Description:
 * @date 2017/06/14
 */
@Entity
@Table(name = "book_info")
public class BookInfo extends BaseUuidEntity{
    private String userName;
    private String title;
    private String author;
    private String publisher;
    private String imgUrl;
    private String imgDetail;
    private String oriPrice;
    private String price;
    private String address;
    private String doubanJson;
    private String juheJson;
    private String deleteStatus;
    private String remark;
    private String businessType;
//    private String warehouseInfoID;

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "PUBLISHER")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "IMG_URL")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Column(name = "IMG_DETAIL")
    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    @Column(name = "ORI_PRICE")
    public String getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(String oriPrice) {
        this.oriPrice = oriPrice;
    }

    @Column(name = "PRICE")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "DOUBAN_JSON")
    public String getDoubanJson() {
        return doubanJson;
    }

    public void setDoubanJson(String doubanJson) {
        this.doubanJson = doubanJson;
    }

    @Column(name = "JUHE_JSON")
    public String getJuheJson() {
        return juheJson;
    }

    public void setJuheJson(String juheJson) {
        this.juheJson = juheJson;
    }

    @Column(name = "DELETE_STATUS")
    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "BUSINESS_TYPE")
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

//    @Column(name = "WAREHOUSE_INFO_ID")
//    public String getWarehouseInfoID() {
//        return warehouseInfoID;
//    }
//
//    public void setWarehouseInfoID(String warehouseInfoID) {
//        this.warehouseInfoID = warehouseInfoID;
//    }
}
