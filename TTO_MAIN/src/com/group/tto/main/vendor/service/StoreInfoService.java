package com.group.tto.main.vendor.service;

import java.io.InputStream;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.vo.StoreInfo;

@Repository("vendorStoreInfoService")
public interface StoreInfoService {
  public StoreInfo loadStoreInfo(int sid);

  public int updateStoreInfo(Store store, int sid, String uuid, InputStream is);

  public Configuration getConfiguration(String value);
  
  public int updateStoreInfo(Store store, int sid);
}
