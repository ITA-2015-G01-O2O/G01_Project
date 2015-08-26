package com.group.tto.main.common;

public class StoreSearchCriteria {
  private int storeLocation;
  private String storeType;
  private String sortType;
  private String orderType;

  public String getSortType() {
    return sortType;
  }

  public void setSortType(String sortType) {
    this.sortType = sortType;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getStoreType() {
    return storeType;
  }

  public void setStoreType(String storeType) {
    this.storeType = storeType;
  }

  public int getStoreLocation() {
    return storeLocation;
  }

  public void setStoreLocation(int storeLocation) {
    this.storeLocation = storeLocation;
  }
  
  
  public StoreSearchCriteria() {
    this.storeLocation = 0;
    this.storeType = null;
    this.sortType = null;
    this.orderType = null;

  }

  public StoreSearchCriteria(int storeLocation, String storeType, String sortType, String orderType) {
    super();
    this.storeLocation = storeLocation;    
    this.storeType = storeType;
    this.sortType = sortType;
    this.orderType = orderType;
  }
  
  

}
