package com.group.tto.cmn.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_USER_PROFILE")
public class UserProfile {
  @Id
  @Column(name = "USER_PROFILE_ID")
  @SequenceGenerator(name = "ORDER_ITEM_ID_SEQ", sequenceName = "SEQ_TTO_ORDER_ITEM_ID")
  @GeneratedValue(generator = "ORDER_ITEM_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long userProfileId;
  @Column(name = "FUND")
  private BigDecimal fund;
  @Column(name = "VERSION")
  private Long version;
  @Column(name = "IS_DELETE")
  private Boolean isDelete;

  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_PROFILE_ID")
  private List<Collect> collects = new ArrayList<Collect>();

  public Long getUserProfileId() {
    return userProfileId;
  }

  public void setUserProfileId(Long userProfileId) {
    this.userProfileId = userProfileId;
  }

  public BigDecimal getFund() {
    return fund;
  }

  public void setFund(BigDecimal fund) {
    this.fund = fund;
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

  public List<Collect> getCollects() {
    return collects;
  }

  public void setCollects(List<Collect> collects) {
    this.collects = collects;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((collects == null) ? 0 : collects.hashCode());
    result = prime * result + ((fund == null) ? 0 : fund.hashCode());
    result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
    result = prime * result + ((userProfileId == null) ? 0 : userProfileId.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    UserProfile other = (UserProfile) obj;
    if (collects == null) {
      if (other.collects != null) return false;
    } else if (!collects.equals(other.collects)) return false;
    if (fund == null) {
      if (other.fund != null) return false;
    } else if (!fund.equals(other.fund)) return false;
    if (isDelete == null) {
      if (other.isDelete != null) return false;
    } else if (!isDelete.equals(other.isDelete)) return false;
    if (userProfileId == null) {
      if (other.userProfileId != null) return false;
    } else if (!userProfileId.equals(other.userProfileId)) return false;
    if (version == null) {
      if (other.version != null) return false;
    } else if (!version.equals(other.version)) return false;
    return true;
  }


}
