package com.group.tto.admin.vo;

import com.group.tto.cmn.model.Account;

public class UserSearchVo {
  private Long userId;
  private String userPhone;
  private Boolean isVendor;

  public UserSearchVo() {}

  public UserSearchVo(Account account) {
    this.userId = account.getAccountId();
    this.userPhone = account.getUsername();
    this.isVendor = account.getStore() != null;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public Boolean getIsVendor() {
    return isVendor;
  }

  public void setIsVendor(Boolean isVendor) {
    this.isVendor = isVendor;
  }


}
