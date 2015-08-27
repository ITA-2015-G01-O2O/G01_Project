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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((announcement == null) ? 0 : announcement.hashCode());
    result = prime * result + ((avgDeliverTime == null) ? 0 : avgDeliverTime.hashCode());
    result = prime * result + ((avgPoint == null) ? 0 : avgPoint.hashCode());
    result = prime * result + ((deliverFee == null) ? 0 : deliverFee.hashCode());
    result = prime * result + ((detailLocation == null) ? 0 : detailLocation.hashCode());
    result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
    result = prime * result + ((isHot == null) ? 0 : isHot.hashCode());
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + ((logoPicUrl == null) ? 0 : logoPicUrl.hashCode());
    result = prime * result + ((orders == null) ? 0 : orders.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    result = prime * result + ((productLabels == null) ? 0 : productLabels.hashCode());
    result = prime * result + ((products == null) ? 0 : products.hashCode());
    result = prime * result + ((serviceBeginTime == null) ? 0 : serviceBeginTime.hashCode());
    result = prime * result + ((serviceEndTime == null) ? 0 : serviceEndTime.hashCode());
    result = prime * result + ((startingFee == null) ? 0 : startingFee.hashCode());
    result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
    result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
    result = prime * result + ((storeProfile == null) ? 0 : storeProfile.hashCode());
    result = prime * result + ((typeConfig == null) ? 0 : typeConfig.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Store other = (Store) obj;
    if (announcement == null) {
      if (other.announcement != null) return false;
    } else if (!announcement.equals(other.announcement)) return false;
    if (avgDeliverTime == null) {
      if (other.avgDeliverTime != null) return false;
    } else if (!avgDeliverTime.equals(other.avgDeliverTime)) return false;
    if (avgPoint == null) {
      if (other.avgPoint != null) return false;
    } else if (!avgPoint.equals(other.avgPoint)) return false;
    if (deliverFee == null) {
      if (other.deliverFee != null) return false;
    } else if (!deliverFee.equals(other.deliverFee)) return false;
    if (detailLocation == null) {
      if (other.detailLocation != null) return false;
    } else if (!detailLocation.equals(other.detailLocation)) return false;
    if (isDelete == null) {
      if (other.isDelete != null) return false;
    } else if (!isDelete.equals(other.isDelete)) return false;
    if (isHot == null) {
      if (other.isHot != null) return false;
    } else if (!isHot.equals(other.isHot)) return false;
    if (location == null) {
      if (other.location != null) return false;
    } else if (!location.equals(other.location)) return false;
    if (logoPicUrl == null) {
      if (other.logoPicUrl != null) return false;
    } else if (!logoPicUrl.equals(other.logoPicUrl)) return false;
    if (orders == null) {
      if (other.orders != null) return false;
    } else if (!orders.equals(other.orders)) return false;
    if (phone == null) {
      if (other.phone != null) return false;
    } else if (!phone.equals(other.phone)) return false;
    if (productLabels == null) {
      if (other.productLabels != null) return false;
    } else if (!productLabels.equals(other.productLabels)) return false;
    if (products == null) {
      if (other.products != null) return false;
    } else if (!products.equals(other.products)) return false;
    if (serviceBeginTime == null) {
      if (other.serviceBeginTime != null) return false;
    } else if (!serviceBeginTime.equals(other.serviceBeginTime)) return false;
    if (serviceEndTime == null) {
      if (other.serviceEndTime != null) return false;
    } else if (!serviceEndTime.equals(other.serviceEndTime)) return false;
    if (startingFee == null) {
      if (other.startingFee != null) return false;
    } else if (!startingFee.equals(other.startingFee)) return false;
    if (storeId == null) {
      if (other.storeId != null) return false;
    } else if (!storeId.equals(other.storeId)) return false;
    if (storeName == null) {
      if (other.storeName != null) return false;
    } else if (!storeName.equals(other.storeName)) return false;
    if (storeProfile == null) {
      if (other.storeProfile != null) return false;
    } else if (!storeProfile.equals(other.storeProfile)) return false;
    if (typeConfig == null) {
      if (other.typeConfig != null) return false;
    } else if (!typeConfig.equals(other.typeConfig)) return false;
    if (version == null) {
      if (other.version != null) return false;
    } else if (!version.equals(other.version)) return false;
    return true;
  }



}
