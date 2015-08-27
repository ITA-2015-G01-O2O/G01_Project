package com.group.tto.main.vendor.service.impl;

import java.io.InputStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.FileDao;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.CompleteInfoService;

@Service("vendorCompleteInfoServiceImpl")
public class CompleteInfoServiceImpl implements CompleteInfoService {

  @Autowired
  private StoreDao storeDao;
  @Autowired
  private FileDao f;

  @Override
  @Transactional
  public int updateStoreInfo(Store store, int sid, String uuid, InputStream is) {
    int num = 1;
    try {
      Store store1 = storeDao.getStoreById(sid);
      store1.setAnnouncement(store.getAnnouncement());
      store1.setStartingFee(store.getStartingFee());
      store1.setDeliverFee(store.getDeliverFee());
      store1.setServiceBeginTime(store.getServiceBeginTime());
      store1.setServiceEndTime(store.getServiceEndTime());
      store1.setLogoPicUrl(store.getLogoPicUrl());
      f.saveFile(is, uuid);
      
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

  public FileDao getF() {
    return f;
  }

  public void setF(FileDao f) {
    this.f = f;
  }

  
}
