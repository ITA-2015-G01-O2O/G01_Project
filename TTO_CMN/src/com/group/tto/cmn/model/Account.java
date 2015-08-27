package com.group.tto.cmn.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_ACCOUNT")
public class Account {
  @Id
  @Column(name = "ACCOUNT_ID")
  @SequenceGenerator(name = "ACCOUNT_ID_SEQ", sequenceName = "SEQ_TTO_ACCOUNT_ID")
  @GeneratedValue(generator = "ACCOUNT_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long accountId;
  @Column(name = "USERNAME")
  private String username;
  @Column(name = "PASSWORD")
  private String password;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "USER_PROFILE_ID")
  private UserProfile userProfile;
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "STORE_ID")
  private Store store;

  @Column(name = "VERSION")
  private Long version;
  @Column(name = "IS_DELETE")
  private Boolean isDelete;

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
    result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
    result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((store == null) ? 0 : store.hashCode());
    result = prime * result + ((userProfile == null) ? 0 : userProfile.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Account other = (Account) obj;
    if (accountId == null) {
      if (other.accountId != null) return false;
    } else if (!accountId.equals(other.accountId)) return false;
    if (isDelete == null) {
      if (other.isDelete != null) return false;
    } else if (!isDelete.equals(other.isDelete)) return false;
    if (password == null) {
      if (other.password != null) return false;
    } else if (!password.equals(other.password)) return false;
    if (store == null) {
      if (other.store != null) return false;
    } else if (!store.equals(other.store)) return false;
    if (userProfile == null) {
      if (other.userProfile != null) return false;
    } else if (!userProfile.equals(other.userProfile)) return false;
    if (username == null) {
      if (other.username != null) return false;
    } else if (!username.equals(other.username)) return false;
    if (version == null) {
      if (other.version != null) return false;
    } else if (!version.equals(other.version)) return false;
    return true;
  }



}
