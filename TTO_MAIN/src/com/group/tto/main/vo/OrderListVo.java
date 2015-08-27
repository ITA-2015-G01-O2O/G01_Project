package com.group.tto.main.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderListVo {
    private Long orderId;
	private String storeName;//res name;
	private String phone;//res phone;
	private String orderNumber;
	private Date createTime;
	private String status;//order status    
	private List<OrderEachItem> orderEachItemList;	
	private String contacterName;
	private String contacterPhone;
	private String detailLocation;
	private String remarks;
	private String context;//comment text
	private String logoPicUrl;
	private BigDecimal deliverTime;
	private BigDecimal point;

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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderEachItem> getOrderEachItemList() {
		return orderEachItemList;
	}
	public void setOrderEachItemList(List<OrderEachItem> orderEachItemList) {
		this.orderEachItemList = orderEachItemList;
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
	public String getDetailLocation() {
		return detailLocation;
	}
	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getLogoPicUrl() {
		return logoPicUrl;
	}
	public void setLogoPicUrl(String logoPicUrl) {
		this.logoPicUrl = logoPicUrl;
	}
  public Long getOrderId() {
    return orderId;
  }
  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
  public BigDecimal getDeliverTime() {
    return deliverTime;
  }
  public void setDeliverTime(BigDecimal deliverTime) {
    this.deliverTime = deliverTime;
  }
  public BigDecimal getPoint() {
    return point;
  }
  public void setPoint(BigDecimal point) {
    this.point = point;
  }

}
