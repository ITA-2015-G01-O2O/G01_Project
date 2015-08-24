package com.group.tto.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_COLLECT")
public class Collect {
  @Id
  @Column(name = "COLLECT_ID")
  @SequenceGenerator(name = "ORDER_COLLECT_SEQ", sequenceName = "SEQ_TTO_COLLECT_ID")
  @GeneratedValue(generator = "ORDER_COLLECT_SEQ", strategy = GenerationType.SEQUENCE)
  private Long collectId;

  @ManyToOne(targetEntity = UserProfile.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "USER_PROFILE_ID")
  private UserProfile userProfile;
  @ManyToOne(targetEntity = Store.class, fetch = FetchType.EAGER)
  private Store store;

  public Long getCollectId() {
    return collectId;
  }

  public void setCollectId(Long collectId) {
    this.collectId = collectId;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }


}
