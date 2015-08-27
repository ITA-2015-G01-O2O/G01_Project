package com.group.tto.main.vo;

import java.math.BigDecimal;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;

/**
 * @author LINI5
 *
 */
public class ProductVO {
  private Long productId;
  private String productName;
  private BigDecimal price;
  private BigDecimal salesVolume;
  private BigDecimal point;
  private String productPicUrl;
  private Long version;
  private Boolean isDelete;
  private Long storeId;
  public ProductVO(){
    
  }
  public ProductVO(Product p) {
    super();
    this.productId = p.getProductId();
    this.productName = p.getProductName();
    this.price = p.getPrice();
    this.salesVolume = p.getSalesVolume();
    this.point = p.getPoint();
    this.productPicUrl = p.getProductPicUrl();
    this.version = p.getVersion();
    this.isDelete = p.isDelete();
    this.storeId = p.getStoreId();
  }

  

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

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getSalesVolume() {
    return salesVolume;
  }

  public void setSalesVolume(BigDecimal salesVolume) {
    this.salesVolume = salesVolume;
  }

  public BigDecimal getPoint() {
    return point;
  }

  public void setPoint(BigDecimal point) {
    this.point = point;
  }

  public String getProductPicUrl() {
    return productPicUrl;
  }

  public void setProductPicUrl(String productPicUrl) {
    this.productPicUrl = productPicUrl;
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

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }
  
  
  
}
