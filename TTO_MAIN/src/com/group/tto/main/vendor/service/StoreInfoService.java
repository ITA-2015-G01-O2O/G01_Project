package com.group.tto.main.vendor.service;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Store;
@Repository("vendorStoreInfoService")
public interface StoreInfoService {
  public Store loadStoreInfo(int sid);

  public int updateStoreInfo(Store store, int sid);
}
