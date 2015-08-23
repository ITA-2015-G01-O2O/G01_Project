package com.group.tto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_ORDER")
public class Order {
  @Id
  @Column(name = "ORDER_ID")
  @SequenceGenerator(name = "ORDER_ID_SEQ", sequenceName = "SEQ_TTO_ORDER_ID")
  @GeneratedValue(generator = "ORDER_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long orderId;
  @Column(name = "ORDER_NUMBER")
  private String orderNumber;
  @Column(name = "CREATE_TIME")
  private Date createTime;
  @Column(name = "END_TIME")
  private Date endTime;
  @Column(name = "STATUS")
  private String status;
  @Column(name = "PAY_WAY")
  private String payWay;
  @Column(name = "CONT_NAME")
  private String contacterName;
  @Column(name = "CONT_PHONE")
  private String contacterPhone;
  @Column(name = "REMAKRS")
  private String remarks;
  @Column(name = "DETAIL_LOC")
  private String detailLocation;
  @Column(name = "STORE_ID")
  private Long storeId;

  @ManyToOne(targetEntity = UserProfile.class, fetch = FetchType.EAGER)
  @JoinColumn(name="USER_PROFILE_ID")
  private UserProfile userProfile;
  @ManyToOne(targetEntity = Comment.class, fetch = FetchType.EAGER)
  @JoinColumn(name="COMMENT_ID")
  private Comment comment;

  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "ORDER_ID")
  private List<OrderItem> orderItems = new ArrayList<OrderItem>();

  @Column(name = "VERSION")
  private Long version;
  @Column(name = "IS_DELETE")
  private Boolean isDelete;

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

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
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

  public String getPayWay() {
    return payWay;
  }

  public void setPayWay(String payWay) {
    this.payWay = payWay;
  }



}
