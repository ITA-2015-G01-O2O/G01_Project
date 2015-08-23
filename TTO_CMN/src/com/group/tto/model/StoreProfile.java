package com.group.tto.model;

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


}
