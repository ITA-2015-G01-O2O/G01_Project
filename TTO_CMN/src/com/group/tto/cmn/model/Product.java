package com.group.tto.cmn.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_PRO")
public class Product {
  @Id
  @Column(name = "PRO_ID")
  @SequenceGenerator(name = "PRO_ID_SEQ", sequenceName = "SEQ_TTO_PRO_ID")
  @GeneratedValue(generator = "PRO_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long productId;
  @Column(name = "PRO_NAME")
  private String productName;
  @Column(name = "PRICE")
  private BigDecimal price;
  @Column(name = "PRO_SALES_VOL")
  private BigDecimal salesVolume;
  @Column(name = "POINT")
  private BigDecimal point;
  @Column(name = "PRO_PIC_URL")
  private String productPicUrl;
  @ManyToOne(targetEntity = ProductLabel.class, fetch = FetchType.EAGER)
  private ProductLabel productLabel;
  @Column(name = "VERSION")
  private Long version;
  @Column(name = "IS_DELETE")
  private Boolean isDelete;
  @Column(name = "STORE_ID")
  private Long storeId;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getSalesVolume() {
    return salesVolume;
  }

  public void setSalesVolume(BigDecimal salesVolume) {
    this.salesVolume = salesVolume;
  }

  public String getProductPicUrl() {
    return productPicUrl;
  }

  public void setProductPicUrl(String productPicUrl) {
    this.productPicUrl = productPicUrl;
  }

  public ProductLabel getProductLabel() {
    return productLabel;
  }

  public void setProductLabel(ProductLabel productLabel) {
    this.productLabel = productLabel;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getPoint() {
    return point;
  }

  public void setPoint(BigDecimal point) {
    this.point = point;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Boolean isDelete() {
    return isDelete;
  }

  public void setDelete(Boolean isDelete) {
    this.isDelete = isDelete;
  }

  public Boolean getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(Boolean isDelete) {
    this.isDelete = isDelete;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }



}
