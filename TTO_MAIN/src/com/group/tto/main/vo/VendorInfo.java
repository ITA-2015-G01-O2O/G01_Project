package com.group.tto.main.vo;

import java.math.BigDecimal;

public class VendorInfo {
  private BigDecimal avgDeliverTime;
  private BigDecimal avgPoint;
  private String storeName;
  private long collectionNum;

  public BigDecimal getAvgDeliverTime() {
    return avgDeliverTime;
  }

  public void setAvgDeliverTime(BigDecimal avgDeliverTime) {
    this.avgDeliverTime = avgDeliverTime;
  }

  public BigDecimal getAvgPoint() {
    return avgPoint;
  }

  public void setAvgPoint(BigDecimal avgPoint) {
    this.avgPoint = avgPoint;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public long getCollectionNum() {
    return collectionNum;
  }

  public void setCollectionNum(long collectionNum) {
    this.collectionNum = collectionNum;
  }

}
