package com.group.tto.admin.vo;

import java.text.SimpleDateFormat;

import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.type.StopProfileStatus;

public class ShopViewVo {
  private Long shopId;
  private String status;
  private String idcardNumber;
  private String realName;
  private String idcardPicUrl;
  private String licensePicImg;
  private String realShopPicUrl;
  private Boolean canActive;
  private Boolean canInActive;
  private String shopName;
  private String locationName;
  private String serviceBeginTime;
  private String serviceEndTime;
  private String deliverFee;
  private String startingFee;
  private String avgPoint;
  private String avgDeliverTime;
  private String logoPicUrl;

  public ShopViewVo() {}

  public ShopViewVo(Store store, String basePicUrl) {
    super();
    this.shopId = store.getStoreId();
    this.status = store.getStoreProfile().getStatus();
    this.idcardNumber = store.getStoreProfile().getIdCardNumber();
    this.realName = store.getStoreProfile().getRealName();
    this.idcardPicUrl = basePicUrl + store.getStoreProfile().getIdCardPicUrl();
    this.licensePicImg = basePicUrl + store.getStoreProfile().getLicensePicUrl();
    this.realShopPicUrl = "";
    if (this.status.equals(StopProfileStatus.CHECK.toString())
        || this.status.equals(StopProfileStatus.FREEZE.toString())) {
      this.canActive = true;
      this.canInActive = false;
    } else {
      this.canActive = false;
      this.canInActive = true;
    }
    this.shopName = store.getStoreName();
    this.locationName =
        store.getLocation().getArea() + "," + store.getLocation().getCity() + ","
            + store.getLocation().getPlace();
    this.serviceBeginTime = new SimpleDateFormat("HH:mm").format(store.getServiceBeginTime());
    this.serviceEndTime = new SimpleDateFormat("HH:mm").format(store.getServiceEndTime());
    this.deliverFee = store.getDeliverFee().toString();
    this.startingFee = store.getStartingFee().toString();
    this.avgPoint = store.getAvgPoint().toString();
    this.avgDeliverTime = store.getAvgDeliverTime().toString();
    this.logoPicUrl = basePicUrl + store.getLogoPicUrl();
  }

  public Long getShopId() {
    return shopId;
  }

  public void setShopId(Long shopId) {
    this.shopId = shopId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getIdcardNumber() {
    return idcardNumber;
  }

  public void setIdcardNumber(String idcardNumber) {
    this.idcardNumber = idcardNumber;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getIdcardPicUrl() {
    return idcardPicUrl;
  }

  public void setIdcardPicUrl(String idcardPicUrl) {
    this.idcardPicUrl = idcardPicUrl;
  }

  public String getLicensePicImg() {
    return licensePicImg;
  }

  public void setLicensePicImg(String licensePicImg) {
    this.licensePicImg = licensePicImg;
  }

  public String getRealShopPicUrl() {
    return realShopPicUrl;
  }

  public void setRealShopPicUrl(String realShopPicUrl) {
    this.realShopPicUrl = realShopPicUrl;
  }

  public Boolean getCanActive() {
    return canActive;
  }

  public void setCanActive(Boolean canActive) {
    this.canActive = canActive;
  }

  public Boolean getCanInActive() {
    return canInActive;
  }

  public void setCanInActive(Boolean canInActive) {
    this.canInActive = canInActive;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getServiceBeginTime() {
    return serviceBeginTime;
  }

  public void setServiceBeginTime(String serviceBeginTime) {
    this.serviceBeginTime = serviceBeginTime;
  }

  public String getServiceEndTime() {
    return serviceEndTime;
  }

  public void setServiceEndTime(String serviceEndTime) {
    this.serviceEndTime = serviceEndTime;
  }

  public String getDeliverFee() {
    return deliverFee;
  }

  public void setDeliverFee(String deliverFee) {
    this.deliverFee = deliverFee;
  }

  public String getStartingFee() {
    return startingFee;
  }

  public void setStartingFee(String startingFee) {
    this.startingFee = startingFee;
  }

  public String getAvgPoint() {
    return avgPoint;
  }

  public void setAvgPoint(String avgPoint) {
    this.avgPoint = avgPoint;
  }

  public String getAvgDeliverTime() {
    return avgDeliverTime;
  }

  public void setAvgDeliverTime(String avgDeliverTime) {
    this.avgDeliverTime = avgDeliverTime;
  }

  public String getLogoPicUrl() {
    return logoPicUrl;
  }

  public void setLogoPicUrl(String logoPicUrl) {
    this.logoPicUrl = logoPicUrl;
  }


}
