package com.group.tto.cmn.model;

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
import javax.persistence.OneToOne;
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
  @JoinColumn(name = "USER_PROFILE_ID")
  private UserProfile userProfile;
  @OneToOne(targetEntity = Comment.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "COMMENT_ID")
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((comment == null) ? 0 : comment.hashCode());
    result = prime * result + ((contacterName == null) ? 0 : contacterName.hashCode());
    result = prime * result + ((contacterPhone == null) ? 0 : contacterPhone.hashCode());
    result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
    result = prime * result + ((detailLocation == null) ? 0 : detailLocation.hashCode());
    result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
    result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
    result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
    result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
    result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
    result = prime * result + ((payWay == null) ? 0 : payWay.hashCode());
    result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
    result = prime * result + ((userProfile == null) ? 0 : userProfile.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Order other = (Order) obj;
    if (comment == null) {
      if (other.comment != null) return false;
    } else if (!comment.equals(other.comment)) return false;
    if (contacterName == null) {
      if (other.contacterName != null) return false;
    } else if (!contacterName.equals(other.contacterName)) return false;
    if (contacterPhone == null) {
      if (other.contacterPhone != null) return false;
    } else if (!contacterPhone.equals(other.contacterPhone)) return false;
    if (createTime == null) {
      if (other.createTime != null) return false;
    } else if (!createTime.equals(other.createTime)) return false;
    if (detailLocation == null) {
      if (other.detailLocation != null) return false;
    } else if (!detailLocation.equals(other.detailLocation)) return false;
    if (endTime == null) {
      if (other.endTime != null) return false;
    } else if (!endTime.equals(other.endTime)) return false;
    if (isDelete == null) {
      if (other.isDelete != null) return false;
    } else if (!isDelete.equals(other.isDelete)) return false;
    if (orderId == null) {
      if (other.orderId != null) return false;
    } else if (!orderId.equals(other.orderId)) return false;
    if (orderItems == null) {
      if (other.orderItems != null) return false;
    } else if (!orderItems.equals(other.orderItems)) return false;
    if (orderNumber == null) {
      if (other.orderNumber != null) return false;
    } else if (!orderNumber.equals(other.orderNumber)) return false;
    if (payWay == null) {
      if (other.payWay != null) return false;
    } else if (!payWay.equals(other.payWay)) return false;
    if (remarks == null) {
      if (other.remarks != null) return false;
    } else if (!remarks.equals(other.remarks)) return false;
    if (status == null) {
      if (other.status != null) return false;
    } else if (!status.equals(other.status)) return false;
    if (storeId == null) {
      if (other.storeId != null) return false;
    } else if (!storeId.equals(other.storeId)) return false;
    if (userProfile == null) {
      if (other.userProfile != null) return false;
    } else if (!userProfile.equals(other.userProfile)) return false;
    if (version == null) {
      if (other.version != null) return false;
    } else if (!version.equals(other.version)) return false;
    return true;
  }



}
