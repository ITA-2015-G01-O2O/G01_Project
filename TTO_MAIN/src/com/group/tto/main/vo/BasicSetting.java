package com.group.tto.main.vo;

import java.math.BigDecimal;
import java.util.Date;

public class BasicSetting {
  private String announcement;
  private BigDecimal deliverFee;
  private BigDecimal startingFee;
  private Date serviceBeginTime;
  private Date serviceEndTime;

  public BasicSetting(String announcement, BigDecimal deliverFee, BigDecimal startingFee,
      Date serviceBeginTime, Date serviceEndTime) {
    super();
    this.announcement = announcement;
    this.deliverFee = deliverFee;
    this.startingFee = startingFee;
    this.serviceBeginTime = serviceBeginTime;
    this.serviceEndTime = serviceEndTime;
  }

  public BasicSetting() {

  }

  public String getAnnouncement() {
    return announcement;
  }

  public void setAnnouncement(String announcement) {
    this.announcement = announcement;
  }

  public BigDecimal getDeliverFee() {
    return deliverFee;
  }

  public void setDeliverFee(BigDecimal deliverFee) {
    this.deliverFee = deliverFee;
  }

  public BigDecimal getStartingFee() {
    return startingFee;
  }

  public void setStartingFee(BigDecimal startingFee) {
    this.startingFee = startingFee;
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

}
