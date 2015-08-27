package com.group.tto.main.vo;

import java.math.BigDecimal;
import java.util.Date;

public class UserFavVendorsVo {
  private Long storeId;
  private String storeName;
  private BigDecimal avgPoint;
  private BigDecimal orderAmount;
  private BigDecimal collectAmount;
  private Date serviceBeginTime;
  private Date serviceEndTime;
  private String logoPicUrl;
  private String phone;
  private String detailLocation;

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public BigDecimal getAvgPoint() {
    return avgPoint;
  }

  public void setAvgPoint(BigDecimal avgPoint) {
    this.avgPoint = avgPoint;
  }

  public BigDecimal getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(BigDecimal orderAmount) {
    this.orderAmount = orderAmount;
  }

  public BigDecimal getCollectAmount() {
    return collectAmount;
  }

  public void setCollectAmount(BigDecimal collectAmount) {
    this.collectAmount = collectAmount;
  }

  public Date getServiceBeginTime() {
    return serviceBeginTime;
  }

  public void setServiceBeginTime(Date serviceBeginTime) {
    this.serviceBeginTime = serviceBeginTime;
  }

  public Date getServiceEndTime() {
    return serviceEndTime;
  }

  public void setServiceEndTime(Date serviceEndTime) {
    this.serviceEndTime = serviceEndTime;
  }

  public String getLogoPicUrl() {
    return logoPicUrl;
  }

  public void setLogoPicUrl(String logoPicUrl) {
    this.logoPicUrl = logoPicUrl;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getDetailLocation() {
    return detailLocation;
  }

  public void setDetailLocation(String detailLocation) {
    this.detailLocation = detailLocation;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }


}
