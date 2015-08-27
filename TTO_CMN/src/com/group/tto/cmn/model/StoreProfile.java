package com.group.tto.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_STORE_PROFILE")
public class StoreProfile {
  @Id
  @Column(name = "STORE_PROFILE_ID")
  @SequenceGenerator(name = "STORE_PRO_ID_SEQ", sequenceName = "SEQ_TTO_STORE_PRO_ID")
  @GeneratedValue(generator = "STORE_PRO_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long storeProfileId;
  @Column(name = "REAL_NAME")
  private String realName;
  @Column(name = "STATUS")
  private String status;
  @Column(name = "ID_CARD_NUMBER")
  private String idCardNumber;
  @Column(name = "ID_CARD_PIC_URL")
  private String idCardPicUrl;
  @Column(name = "LIC_PIC_URL")
  private String licensePicUrl;

  @Column(name = "VERSION")
  private Long version;
  @Column(name = "IS_DELETE")
  private Boolean isDelete;

  public Long getStoreProfileId() {
    return storeProfileId;
  }

  public void setStoreProfileId(Long storeProfileId) {
    this.storeProfileId = storeProfileId;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getIdCardNumber() {
    return idCardNumber;
  }

  public void setIdCardNumber(String idCardNumber) {
    this.idCardNumber = idCardNumber;
  }

  public String getIdCardPicUrl() {
    return idCardPicUrl;
  }

  public void setIdCardPicUrl(String idCardPicUrl) {
    this.idCardPicUrl = idCardPicUrl;
  }

  public String getLicensePicUrl() {
    return licensePicUrl;
  }

  public void setLicensePicUrl(String licensePicUrl) {
    this.licensePicUrl = licensePicUrl;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idCardNumber == null) ? 0 : idCardNumber.hashCode());
    result = prime * result + ((idCardPicUrl == null) ? 0 : idCardPicUrl.hashCode());
    result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
    result = prime * result + ((licensePicUrl == null) ? 0 : licensePicUrl.hashCode());
    result = prime * result + ((realName == null) ? 0 : realName.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    result = prime * result + ((storeProfileId == null) ? 0 : storeProfileId.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    StoreProfile other = (StoreProfile) obj;
    if (idCardNumber == null) {
      if (other.idCardNumber != null) return false;
    } else if (!idCardNumber.equals(other.idCardNumber)) return false;
    if (idCardPicUrl == null) {
      if (other.idCardPicUrl != null) return false;
    } else if (!idCardPicUrl.equals(other.idCardPicUrl)) return false;
    if (isDelete == null) {
      if (other.isDelete != null) return false;
    } else if (!isDelete.equals(other.isDelete)) return false;
    if (licensePicUrl == null) {
      if (other.licensePicUrl != null) return false;
    } else if (!licensePicUrl.equals(other.licensePicUrl)) return false;
    if (realName == null) {
      if (other.realName != null) return false;
    } else if (!realName.equals(other.realName)) return false;
    if (status == null) {
      if (other.status != null) return false;
    } else if (!status.equals(other.status)) return false;
    if (storeProfileId == null) {
      if (other.storeProfileId != null) return false;
    } else if (!storeProfileId.equals(other.storeProfileId)) return false;
    if (version == null) {
      if (other.version != null) return false;
    } else if (!version.equals(other.version)) return false;
    return true;
  }


}
