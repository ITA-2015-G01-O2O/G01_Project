package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.CompleteInfoService;

@Service
public class CompleteInfoServiceImpl implements CompleteInfoService{
  
  @Autowired
  private StoreDao storeDao;

  @Override
  @Transactional
  public int updateStoreInfo(Store store,int sid) {
    try {
      Store store1=storeDao.getStoreById(sid);
      store1.setAnnouncement(store.getAnnouncement());
      store1.setStartingFee(store.getStartingFee());
      store1.setDeliverFee(store.getDeliverFee());
      store1.setServiceBeginTime(store.getServiceBeginTime());
      store1.setServiceEndTime(store.getServiceEndTime());
      store1.setLogoPicUrl(store.getLogoPicUrl());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }

}
