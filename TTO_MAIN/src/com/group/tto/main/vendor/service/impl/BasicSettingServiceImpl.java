package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.BasicSettingService;

@Service("vendorBasicSettingServiceImpl")
public class BasicSettingServiceImpl implements BasicSettingService {

  @Autowired
  private StoreDao storeDao;
  
  @Override
  @Transactional
  public int updateBasicSetting(int sid, Store store) {
    int num=1;
    try {
      Store store1=storeDao.getStoreById(sid);
      store1.setAnnouncement(store.getAnnouncement());
      store1.setStartingFee(store.getStartingFee());
      store1.setDeliverFee(store.getDeliverFee());
      store1.setServiceBeginTime(store.getServiceBeginTime());
      store1.setServiceEndTime(store.getServiceEndTime());
    } catch (Exception e) {
      num=0;
      e.printStackTrace();
    }
    return num;
  }

  @Override
  public Store loadBasicSetting(int sid) {
    Store store=storeDao.getStoreById(sid);
    return store;
  }

  public StoreDao getStoreDao() {
    return storeDao;
  }

  public void setStoreDao(StoreDao storeDao) {
    this.storeDao = storeDao;
  }

}
