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

  @Column(name = "USER_PROFILE_ID")
  private Long userProfileId;
  @ManyToOne(targetEntity = Store.class, fetch = FetchType.EAGER)
  private Store store;

  public Long getCollectId() {
    return collectId;
  }

  public void setCollectId(Long collectId) {
    this.collectId = collectId;
  }

  public Long getUserProfileId() {
    return userProfileId;
  }

  public void setUserProfileId(Long userProfileId) {
    this.userProfileId = userProfileId;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((collectId == null) ? 0 : collectId.hashCode());
    result = prime * result + ((store == null) ? 0 : store.hashCode());
    result = prime * result + ((userProfileId == null) ? 0 : userProfileId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Collect other = (Collect) obj;
    if (collectId == null) {
      if (other.collectId != null) return false;
    } else if (!collectId.equals(other.collectId)) return false;
    if (store == null) {
      if (other.store != null) return false;
    } else if (!store.equals(other.store)) return false;
    if (userProfileId == null) {
      if (other.userProfileId != null) return false;
    } else if (!userProfileId.equals(other.userProfileId)) return false;
    return true;
  }


}
