package com.group.tto.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_PRO_LABEL")
public class ProductLabel {
  @Id
  @Column(name = "PRO_LABEL_ID")
  @SequenceGenerator(name = "PRO_LABEL_ID_SEQ", sequenceName = "SEQ_TTO_PRO_LABEL_ID")
  @GeneratedValue(generator = "PRO_LABEL_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long productLabelId;
  @Column(name = "PRO_LABEL_NAME")
  private String productLabelName;
  @Column(name = "STORE_ID")
  private Long storeId;

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
