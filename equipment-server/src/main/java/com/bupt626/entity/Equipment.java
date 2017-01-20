package com.bupt626.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hexiuyu on 2017/1/19.
 */
@Entity
@Table(name = "equipment")
public class Equipment {
    private Long id;
    private Integer lineNo;
    private String equipmentNo;
    private String internationalCategory;
    private String internationalBroadCategory;
    private String equipmentCategory;
    private String equipmentBroadCategory;
    private String equipmentName;
    private Integer count;
    private Float size;
    private Double value;
    private String educationUsageDire;
    private String valueType;
    private Date inAccountDate;
    private String getWay;
    private Date getDate;
    private Date guaranteeDate;
    private String usageDepartment;
    private String usageDirection;
    private String usageStatus;
    private String user;
    private String location;
    private String remarks;
    private Integer checkNo;
    private String usageProperty;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getInternationalCategory() {
        return internationalCategory;
    }

    public void setInternationalCategory(String internationalCategory) {
        this.internationalCategory = internationalCategory;
    }

    public String getInternationalBroadCategory() {
        return internationalBroadCategory;
    }

    public void setInternationalBroadCategory(String internationalBroadCategory) {
        this.internationalBroadCategory = internationalBroadCategory;
    }

    public String getEquipmentCategory() {
        return equipmentCategory;
    }

    public void setEquipmentCategory(String equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public String getEquipmentBroadCategory() {
        return equipmentBroadCategory;
    }

    public void setEquipmentBroadCategory(String equipmentBroadCategory) {
        this.equipmentBroadCategory = equipmentBroadCategory;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Float getSize() {
        return size;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getEducationUsageDire() {
        return educationUsageDire;
    }

    public void setEducationUsageDire(String educationUsageDire) {
        this.educationUsageDire = educationUsageDire;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Date getInAccountDate() {
        return inAccountDate;
    }

    public void setInAccountDate(Date inAccountDate) {
        this.inAccountDate = inAccountDate;
    }

    public String getGetWay() {
        return getWay;
    }

    public void setGetWay(String getWay) {
        this.getWay = getWay;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Date getGuaranteeDate() {
        return guaranteeDate;
    }

    public void setGuaranteeDate(Date guaranteeDate) {
        this.guaranteeDate = guaranteeDate;
    }

    public String getUsageDepartment() {
        return usageDepartment;
    }

    public void setUsageDepartment(String usageDepartment) {
        this.usageDepartment = usageDepartment;
    }

    public String getUsageDirection() {
        return usageDirection;
    }

    public void setUsageDirection(String usageDirection) {
        this.usageDirection = usageDirection;
    }

    public String getUsageStatus() {
        return usageStatus;
    }

    public void setUsageStatus(String usageStatus) {
        this.usageStatus = usageStatus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(Integer checkNo) {
        this.checkNo = checkNo;
    }

    public String getUsageProperty() {
        return usageProperty;
    }

    public void setUsageProperty(String usageProperty) {
        this.usageProperty = usageProperty;
    }
}
