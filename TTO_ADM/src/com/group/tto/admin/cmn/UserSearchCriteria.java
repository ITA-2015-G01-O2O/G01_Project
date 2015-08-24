package com.group.tto.admin.cmn;

public class UserSearchCriteria extends BaseSearchCriteria {
  private String userPhone;
  private Boolean isVendor;

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
