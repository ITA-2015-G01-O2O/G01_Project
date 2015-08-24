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

  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
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


}
