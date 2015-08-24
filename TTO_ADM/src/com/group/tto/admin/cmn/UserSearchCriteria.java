package com.group.tto.admin.cmn;

public class UserSearchCriteria extends BaseSearchCriteria {
  private String userPhone;
  private boolean isVendor;

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public boolean isVendor() {
    return isVendor;
  }

  public void setVendor(boolean isVendor) {
    this.isVendor = isVendor;
  }

}
