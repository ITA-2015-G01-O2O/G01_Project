package com.group.tto.admin.vo;

import com.group.tto.cmn.model.Store;

public class ShopSearchVo {
  private Long shopId;
  private String shopName;
  private String ownerName;
  private Boolean isHot;
  private String status;
  private String locationName;

  public ShopSearchVo() {}

  public ShopSearchVo(Store store) {
    super();
    this.shopId = store.getStoreId();
    this.shopName = store.getStoreName();
    this.ownerName = store.getStoreProfile().getRealName();
    this.isHot = store.getIsHot();
    this.status = store.getStoreProfile().getStatus();
    this.locationName =
        store.getLocation().getArea() + "," + store.getLocation().getCity() + ","
            + store.getLocation().getPlace();
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

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
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

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }



}
