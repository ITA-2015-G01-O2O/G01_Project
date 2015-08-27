package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.CollectDao;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.VendorInfoService;
import com.group.tto.main.vo.VendorInfo;

@Service
public class VendorInfoServiceImpl implements VendorInfoService {

  @Autowired
  private CollectDao c;
  @Autowired
  private StoreDao s;

  @Override
  @Transactional
  public VendorInfo getVendorInfo(int sid) {
    VendorInfo v = new VendorInfo();
    Store store = s.getStoreById(sid);
    v.setAvgDeliverTime(store.getAvgDeliverTime());
    v.setAvgPoint(store.getAvgPoint());
    v.setStoreName(store.getStoreName());

    long num = c.findAllCollectsByStore(store);
    v.setCollectionNum(num);
    return v;
  }

  public CollectDao getC() {
    return c;
  }

  public void setC(CollectDao c) {
    this.c = c;
  }

  public StoreDao getStore() {
    return s;
  }

  public void setStore(StoreDao store) {
    this.s = store;
  }



}
