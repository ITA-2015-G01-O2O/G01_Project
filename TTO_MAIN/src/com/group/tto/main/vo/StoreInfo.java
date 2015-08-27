package com.group.tto.main.vo;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Location;

public class StoreInfo {
  private String storeName;
  private String phone;
  private Configuration typeConfig;
  private String logoPicUrl;
  private Location location;
  private String detailLocation;

  
  public String getDetailLocation() {
    return detailLocation;
  }

  public void setDetailLocation(String detailLocation) {
    this.detailLocation = detailLocation;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Configuration getTypeConfig() {
    return typeConfig;
  }

  public void setTypeConfig(Configuration typeConfig) {
    this.typeConfig = typeConfig;
  }

  public String getLogoPicUrl() {
    return logoPicUrl;
  }

  public void setLogoPicUrl(String logoPicUrl) {
    this.logoPicUrl = logoPicUrl;
  }

}
