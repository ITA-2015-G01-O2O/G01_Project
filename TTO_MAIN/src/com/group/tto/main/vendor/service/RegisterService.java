package com.group.tto.main.vendor.service;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Store;
@Repository("vendorProductService")
public interface RegisterService {
  public int storeRegister(Store store,int uid);
}
