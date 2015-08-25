package com.group.tto.main.vendor.service;

import java.io.InputStream;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Store;

@Repository("vendorProductService")
public interface VendorRegisterService {
  public int storeRegister(Store store, int uid, String uuid1, InputStream is1, String uuid2,
      InputStream is2);

  public int getLocation(String area, String place, String city);

  public Configuration getConfiguration(String value);
}
