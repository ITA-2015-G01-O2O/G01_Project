package com.group.tto.cmn.model;

import java.math.BigDecimal;
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
@Table(name = "TTO_STORE")
public class Store {
  @Id
  @Column(name = "STORE_ID")
  @SequenceGenerator(name = "STORE_ID_SEQ", sequenceName = "SEQ_TTO_STORE_ID")
  @GeneratedValue(generator = "STORE_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long storeId;
  @Column(name = "STORE_NAME")
  private String storeName;
  @Column(name = "PHONE")
  private String phone;
  @Column(name = "DETAIL_LOC")
  private String detailLocation;
  @Column(name = "SERVICE_BEGIN_TIME")
  private Date serviceBeginTime;
  @Column(name = "SERVICE_END_TIME")
  private Date serviceEndTime;
  @Column(name = "DELIVER_FEE")
  private BigDecimal deliverFee;
  @Column(name = "STARTING_FEE")
  private BigDecimal startingFee;
  @Column(name = "AVG_POINT")
  private BigDecimal avgPoint;
  @Column(name = "AVG_DELIVER_TIME")
  private BigDecimal avgDeliverTime;
  @Column(name = "ANNOUNCEMENT")
  private String announcement;
  @Column(name = "IS_HOT")
  private Boolean isHot;
  @Column(name = "LOGO_PIC_URL")
  private String logoPicUrl;
  @ManyToOne(targetEntity = Configuration.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "TYPE_CONFIG_ID")
  private Configuration typeConfig;

  @ManyToOne(targetEntity = Location.class, fetch = FetchType.EAGER)
  private Location location;
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "STORE_PROFILE_ID")
  private StoreProfile storeProfile;

  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "STORE_ID")
  private List<Product> products = new ArrayList<Product>();
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "STORE_ID")
  private List<ProductLabel> productLabels = new ArrayList<ProductLabel>();
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "STORE_ID")
  private List<Order> orders = new ArrayList<Order>();

  @Column(name = "VERSION")
  private Long version;
  @Column(name = "IS_DELETE")
  private Boolean isDelete;

  public Long getStoreId() {
    return storeId;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
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

  public StoreProfile getStoreProfile() {
    return storeProfile;
  }

  public void setStoreProfile(StoreProfile storeProfile) {
    this.storeProfile = storeProfile;
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

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public List<ProductLabel> getProductLabels() {
    return productLabels;
  }

  public void setProductLabels(List<ProductLabel> productLabels) {
    this.productLabels = productLabels;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  public String getAnnouncement() {
    return announcement;
  }

  public void setAnnouncement(String announcement) {
    this.announcement = announcement;
  }

  public Boolean getIsHot() {
    return isHot;
  }

  public void setIsHot(Boolean isHot) {
    this.isHot = isHot;
  }

  public String getLogoPicUrl() {
    return logoPicUrl;
  }

  public void setLogoPicUrl(String logoPicUrl) {
    this.logoPicUrl = logoPicUrl;
  }

  public Configuration getTypeConfig() {
    return typeConfig;
  }

  public void setTypeConfig(Configuration typeConfig) {
    this.typeConfig = typeConfig;
  }



}
