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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
    result = prime * result + ((point == null) ? 0 : point.hashCode());
    result = prime * result + ((price == null) ? 0 : price.hashCode());
    result = prime * result + ((productId == null) ? 0 : productId.hashCode());
    result = prime * result + ((productLabel == null) ? 0 : productLabel.hashCode());
    result = prime * result + ((productName == null) ? 0 : productName.hashCode());
    result = prime * result + ((productPicUrl == null) ? 0 : productPicUrl.hashCode());
    result = prime * result + ((salesVolume == null) ? 0 : salesVolume.hashCode());
    result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Product other = (Product) obj;
    if (isDelete == null) {
      if (other.isDelete != null) return false;
    } else if (!isDelete.equals(other.isDelete)) return false;
    if (point == null) {
      if (other.point != null) return false;
    } else if (!point.equals(other.point)) return false;
    if (price == null) {
      if (other.price != null) return false;
    } else if (!price.equals(other.price)) return false;
    if (productId == null) {
      if (other.productId != null) return false;
    } else if (!productId.equals(other.productId)) return false;
    if (productLabel == null) {
      if (other.productLabel != null) return false;
    } else if (!productLabel.equals(other.productLabel)) return false;
    if (productName == null) {
      if (other.productName != null) return false;
    } else if (!productName.equals(other.productName)) return false;
    if (productPicUrl == null) {
      if (other.productPicUrl != null) return false;
    } else if (!productPicUrl.equals(other.productPicUrl)) return false;
    if (salesVolume == null) {
      if (other.salesVolume != null) return false;
    } else if (!salesVolume.equals(other.salesVolume)) return false;
    if (storeId == null) {
      if (other.storeId != null) return false;
    } else if (!storeId.equals(other.storeId)) return false;
    if (version == null) {
      if (other.version != null) return false;
    } else if (!version.equals(other.version)) return false;
    return true;
  }



}
