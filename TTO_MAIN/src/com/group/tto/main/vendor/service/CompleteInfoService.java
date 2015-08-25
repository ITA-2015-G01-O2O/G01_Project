package com.group.tto.main.vendor.service;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Store;
@Repository("vendorCompleteInfoService")
public interface CompleteInfoService {
  public int updateStoreInfo(Store store,int sid);
}
