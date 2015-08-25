package com.group.tto.main.vo;

import java.math.BigDecimal;

import com.group.tto.cmn.model.Store;

public class StoreSearchVo {
  private Long shopId;
  private String shopName;  
  private Boolean isHot;
  private String status;
  
  private String avgPoint;
  private String deliverFee;
  private String startingFee;
  private String logoPicURL;
  private String avgDeliverTime;
  private String storeType;
  private int salesNum;
  
  public StoreSearchVo() {}

  public StoreSearchVo(Store store) {
    super();
    this.shopId = store.getStoreId();
    this.shopName = store.getStoreName();
    this.avgPoint = store.getAvgPoint().toString();
    this.salesNum = store.getOrders().size();
    this.isHot = store.getIsHot();
    this.status = store.getStoreProfile().getStatus();
    this.logoPicURL = store.getLogoPicUrl();
    this.deliverFee = store.getDeliverFee().toString();
    this.startingFee = store.getStartingFee().toString();
    this.avgDeliverTime = store.getAvgDeliverTime().toString();  
    //this.storeType = store.getTypeConfig().getConfigValue();
  }

  public Long getShopId() {
    return shopId;
  }

  public void setShopId(Long shopId) {
    this.shopId = shopId;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public Boolean getIsHot() {
    return isHot;
  }

  public void setIsHot(Boolean isHot) {
    this.isHot = isHot;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getAvgPoint() {
    return avgPoint;
  }

  public void setAvgPoint(String avgPoint) {
    this.avgPoint = avgPoint;
  }

  public String getDeliverFee() {
    return deliverFee;
  }

  public void setDeliverFee(String deliverFee) {
    this.deliverFee = deliverFee;
  }

  public String getLogoPicURL() {
    return logoPicURL;
  }

  public void setLogoPicURL(String logoPicURL) {
    this.logoPicURL = logoPicURL;
  }

  public String getStartingFee() {
    return startingFee;
  }

  public void setStartingFee(String startingFee) {
    this.startingFee = startingFee;
  }

  public int getSalesNum() {
    return salesNum;
  }

  public void setSalesNum(int salesNum) {
    this.salesNum = salesNum;
  }

  public String getAvgDeliverTime() {
    return avgDeliverTime;
  }

  public void setAvgDeliverTime(String avgDeliverTime) {
    this.avgDeliverTime = avgDeliverTime;
  }




}
