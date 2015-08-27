package com.group.tto.main.vo;

import com.group.tto.cmn.model.ProductLabel;

public class ProductLabelVO {
  private Long productLabelId;
  private String productLabelName;
  private Long storeId;
  
  public ProductLabelVO(){
    
  }
  public ProductLabelVO(ProductLabel pl) {
    this.productLabelId=pl.getProductLabelId();
    this.productLabelName=pl.getProductLabelName();
    this.storeId=pl.getStoreId();
  }

  public Long getProductLabelId() {
    return productLabelId;
  }

  public void setProductLabelId(Long productLabelId) {
    this.productLabelId = productLabelId;
  }

  public String getProductLabelName() {
    return productLabelName;
  }

  public void setProductLabelName(String productLabelName) {
    this.productLabelName = productLabelName;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

}
