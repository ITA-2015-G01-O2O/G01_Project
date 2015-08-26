package com.group.tto.main.common;

import java.io.Serializable;

public class OrderJMSMsg implements Serializable, Cloneable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String id;
  private Long orderId;
  private Long storeId;
  private String flag;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  @Override
  public OrderJMSMsg clone() {
    try {
      return (OrderJMSMsg) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }



}
