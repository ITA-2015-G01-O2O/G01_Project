package com.group.tto.main.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.group.tto.cmn.model.Comment;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.OrderItem;

public class OrderVO {

  private Long orderId;

  private String orderNumber;
  private Date createTime;
  private Date endTime;
  private String status;
  private String payWay;
  private String contacterName;
  private String contacterPhone;
  private String remarks;
  private String detailLocation;
  private Long storeId;
  private List<OrderItem> orderItems = new ArrayList<OrderItem>();
  private Comment comment;
  private Long version;
  private Boolean isDelete;

  public OrderVO() {

  }

  public OrderVO(Order pl) {
    super();
    this.orderId = pl.getOrderId();
    this.orderNumber = pl.getOrderNumber();
    this.createTime = pl.getCreateTime();
    this.endTime = pl.getEndTime();
    this.status = pl.getStatus();
    this.payWay = pl.getPayWay();
    this.contacterName = pl.getContacterName();
    this.contacterPhone = pl.getContacterPhone();
    this.remarks = pl.getRemarks();
    this.detailLocation = pl.getDetailLocation();
    this.storeId = pl.getStoreId();
    this.orderItems = pl.getOrderItems();
    if (pl.getComment() != null) {
      this.comment = new Comment();
      this.comment.setCommentId(pl.getComment().getCommentId());
      this.comment.setContext(pl.getComment().getContext());
      this.comment.setDeliverTime(pl.getComment().getDeliverTime());
      this.comment.setPoint(pl.getComment().getPoint());
    }
    this.version = pl.getVersion();
    this.isDelete = pl.getIsDelete();
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPayWay() {
    return payWay;
  }

  public void setPayWay(String payWay) {
    this.payWay = payWay;
  }

  public String getContacterName() {
    return contacterName;
  }

  public void setContacterName(String contacterName) {
    this.contacterName = contacterName;
  }

  public String getContacterPhone() {
    return contacterPhone;
  }

  public void setContacterPhone(String contacterPhone) {
    this.contacterPhone = contacterPhone;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
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

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Boolean getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(Boolean isDelete) {
    this.isDelete = isDelete;
  }



}
