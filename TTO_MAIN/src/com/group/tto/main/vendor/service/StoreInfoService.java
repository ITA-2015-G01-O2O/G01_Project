package com.group.tto.main.vendor.service;

import com.group.tto.cmn.model.Store;

public interface StoreInfoService {
  public Store loadStoreInfo(int sid);

  public int updateStoreInfo(Store store, int sid);
}
