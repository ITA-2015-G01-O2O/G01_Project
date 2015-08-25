package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.StoreInfoService;

@Service
@Repository("vendorStoreInfoServiceImpl")
public class StoreInfoServiceImpl implements StoreInfoService {

  @Autowired
  private StoreDao storeDao;

  @Override
  @Transactional
  public Store loadStoreInfo(int sid) {
    Store store = storeDao.getStoreById(sid);
    return store;
  }

  @Override
  @Transactional
  public int updateStoreInfo(Store store, int sid) {
    int num = 1;
    try {
      Store store1 = storeDao.getStoreById(sid);
      store1.setLocation(store.getLocation());
      store1.setStoreName(store.getStoreName());
      String type = store1.getTypeConfig().getConfigValue();
      store1.getTypeConfig().setConfigValue(type);
      store1.setLogoPicUrl(store.getLogoPicUrl());
    } catch (Exception e) {
      num = 0;
      e.printStackTrace();
    }
    return num;
  }

  public StoreDao getStoreDao() {
    return storeDao;
  }

  public void setStoreDao(StoreDao storeDao) {
    this.storeDao = storeDao;
  }

}
