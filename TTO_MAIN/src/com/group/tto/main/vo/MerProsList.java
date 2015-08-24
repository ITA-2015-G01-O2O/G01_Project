package com.group.tto.main.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;

public class MerProsList {
	private List<Product> products;
	
	private Long storeId;
	private String storeName;
	
	
	private String detailLocation;
	private Date serviceBeginTime;
	private Date serviceEndTime;
	/**
	 * kuai di fei   qisong fei
	 */
	private BigDecimal deliverFee;
	private BigDecimal startingFee;
	
	private BigDecimal avgPoint;
	
	private BigDecimal avgDeliverTime;
	
	/**
	 * gong gao
	 */
	private String announcement;
	
	public MerProsList(){
		
	}
	public MerProsList(Store stroe){
		this.products=stroe.getProducts();
		this.storeId=stroe.getStoreId();
		this.storeName=stroe.getStoreName();
		
		this.detailLocation=stroe.getDetailLocation();
		this.serviceBeginTime=stroe.getServiceBeginTime();
		this.serviceEndTime=stroe.getServiceEndTime();
		/**
		 * kuai di fei   qisong fei
		 */
		this.deliverFee=stroe.getDeliverFee();
		this.startingFee=stroe.getStartingFee();
		
		this.avgPoint=stroe.getAvgPoint();
		
		this.avgDeliverTime=stroe.getAvgDeliverTime();
		
		/**
		 * gong gao
		 */
		this.announcement=stroe.getAnnouncement();
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getDetailLocation() {
		return detailLocation;
	}
	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
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
	public BigDecimal getAvgPoint() {
		return avgPoint;
	}
	public void setAvgPoint(BigDecimal avgPoint) {
		this.avgPoint = avgPoint;
	}
	public BigDecimal getAvgDeliverTime() {
		return avgDeliverTime;
	}
	public void setAvgDeliverTime(BigDecimal avgDeliverTime) {
		this.avgDeliverTime = avgDeliverTime;
	}
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	
	
	
	
}
