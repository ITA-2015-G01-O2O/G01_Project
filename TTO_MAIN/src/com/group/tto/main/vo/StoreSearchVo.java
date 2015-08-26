package com.group.tto.main.vo;

import java.math.BigDecimal;

import com.group.tto.cmn.model.Store;

public class StoreSearchVo {
  private Long shopId;
  private String shopName;
  private Boolean isHot;
  private String status;

  private String avgPoint = "";
  private String deliverFee = "";
  private String startingFee = "";
  private String logoPicURL = "";
  private String avgDeliverTime = "";
  private String storeType = "";
  private int salesNum;

  public StoreSearchVo() {}

  public StoreSearchVo(Store store) {
    super();
    this.shopId = store.getStoreId();
    if (store.getStoreName() != null) {
      this.shopName = store.getStoreName();
    }
    if (store.getAvgPoint() != null) {
      this.avgPoint = store.getAvgPoint().toString();
    }
    this.salesNum = store.getOrders().size();
    this.isHot = store.getIsHot();
    if (store.getStoreProfile() != null) {
      this.status = store.getStoreProfile().getStatus();
    }
    this.logoPicURL = store.getLogoPicUrl();
    if (store.getDeliverFee() != null) {
      this.deliverFee = store.getDeliverFee().toString();
    }
    if (store.getStartingFee() != null) {
      this.startingFee = store.getStartingFee().toString();
    }
    if (store.getAvgDeliverTime() != null) {
      this.avgDeliverTime = store.getAvgDeliverTime().toString();
    }
    if (store.getTypeConfig() != null) {
      this.storeType = store.getTypeConfig().getConfigValue();
    }
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

  public String getStoreType() {
    return storeType;
  }

  public void setStoreType(String storeType) {
    this.storeType = storeType;
  }



}
