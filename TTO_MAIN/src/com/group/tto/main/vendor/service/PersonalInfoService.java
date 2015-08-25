package com.group.tto.main.vendor.service;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.StoreProfile;
@Repository("vendorPersonalInfoService")
public interface PersonalInfoService {
  public StoreProfile loadPersonInfo(int sid);
}
