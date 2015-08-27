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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((productLabelId == null) ? 0 : productLabelId.hashCode());
    result = prime * result + ((productLabelName == null) ? 0 : productLabelName.hashCode());
    result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ProductLabel other = (ProductLabel) obj;
    if (productLabelId == null) {
      if (other.productLabelId != null) return false;
    } else if (!productLabelId.equals(other.productLabelId)) return false;
    if (productLabelName == null) {
      if (other.productLabelName != null) return false;
    } else if (!productLabelName.equals(other.productLabelName)) return false;
    if (storeId == null) {
      if (other.storeId != null) return false;
    } else if (!storeId.equals(other.storeId)) return false;
    return true;
  }


}
