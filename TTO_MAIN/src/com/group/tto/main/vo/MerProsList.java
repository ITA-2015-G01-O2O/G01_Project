package com.group.tto.main.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.cmn.model.Store;

public class MerProsList {
  private List<Product> products;

  private Long storeId;
  private String storeName;
  private String logoPicUrl;

  private String detailLocation;
  private String serviceBeginTime;
  private String serviceEndTime;
  /**
   * kuai di fei qisong fei
   */
  private BigDecimal deliverFee;
  private BigDecimal startingFee;

  private BigDecimal avgPoint;

  private BigDecimal avgDeliverTime;

  private List<ProductLabel> productLabels = new ArrayList<ProductLabel>();
  /**
   * gong gao
   */
  private String announcement;

  List<Order> orders=new ArrayList<Order>();
  private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
  private String phone;
  public MerProsList() {

  }

  public MerProsList(Store stroe) {
    this.phone=stroe.getPhone();
    this.products = stroe.getProducts();
    this.storeId = stroe.getStoreId();
    this.storeName = stroe.getStoreName();

    this.detailLocation = stroe.getDetailLocation();

    this.serviceBeginTime = sdf.format(stroe.getServiceBeginTime());
    this.serviceEndTime = sdf.format(stroe.getServiceEndTime());
    /**
     * kuai di fei qisong fei
     */
    this.deliverFee = stroe.getDeliverFee();
    this.startingFee = stroe.getStartingFee();

    this.orders=stroe.getOrders();
    this.avgPoint = stroe.getAvgPoint();

    this.avgDeliverTime = stroe.getAvgDeliverTime();

    /**
     * gong gao
     */
    this.announcement = stroe.getAnnouncement();
    this.logoPicUrl = stroe.getLogoPicUrl();
    this.productLabels=stroe.getProductLabels();
  }
  public MerProsList(MerProsList stroe) {
    this.phone=stroe.getPhone();
    this.products = stroe.getProducts();
    this.storeId = stroe.getStoreId();
    this.storeName = stroe.getStoreName();

    this.detailLocation = stroe.getDetailLocation();

    this.serviceBeginTime = stroe.getServiceBeginTime();
    this.serviceEndTime = stroe.getServiceEndTime();
    /**
     * kuai di fei qisong fei
     */
    this.deliverFee = stroe.getDeliverFee();
    this.startingFee = stroe.getStartingFee();

    this.orders=stroe.getOrders();
    this.avgPoint = stroe.getAvgPoint();

    this.avgDeliverTime = stroe.getAvgDeliverTime();

    /**
     * gong gao
     */
    this.announcement = stroe.getAnnouncement();
    this.logoPicUrl = stroe.getLogoPicUrl();
    this.productLabels=stroe.getProductLabels();
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  public String getLogoPicUrl() {
    return logoPicUrl;
  }

  public List<ProductLabel> getProductLabels() {
    return productLabels;
  }

  public void setProductLabels(List<ProductLabel> productLabels) {
    this.productLabels = productLabels;
  }

  public void setLogoPicUrl(String logoPicUrl) {
    this.logoPicUrl = logoPicUrl;
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
