package com.group.tto.main.vendor.service.impl;

import java.io.InputStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.FileDao;
import com.group.tto.main.vendor.dao.ConfigurationDao;
import com.group.tto.main.vendor.dao.StoreDao;
import com.group.tto.main.vendor.service.StoreInfoService;
import com.group.tto.main.vo.StoreInfo;

@Service("vendorStoreInfoServiceImpl")
public class StoreInfoServiceImpl implements StoreInfoService {

  @Autowired
  private StoreDao storeDao;
  @Autowired
  private FileDao f;
  @Autowired
  private ConfigurationDao conDao;

  @Override
  @Transactional
  public StoreInfo loadStoreInfo(int sid) {
    Store store = storeDao.getStoreById(sid);

    StoreInfo si = new StoreInfo();
    si.setLogoPicUrl(store.getLogoPicUrl());
    si.setPhone(store.getPhone());
    si.setStoreName(store.getStoreName());
    si.setTypeConfig(store.getTypeConfig());
    si.setLocation(store.getLocation());
    si.setDetailLocation(store.getDetailLocation());

    return si;
  }

  @Override
  @Transactional
  public int updateStoreInfo(Store store, int sid, String uuid, InputStream is) {
    int num = 1;
    try {
      Store store1 = storeDao.getStoreById(sid);
      store1.setPhone(store.getPhone());
      store1.setStoreName(store.getStoreName());
      store1.setTypeConfig(store.getTypeConfig());
      store1.setLogoPicUrl(store.getLogoPicUrl());
      f.saveFile(is, uuid);

    } catch (Exception e) {
      num = 0;
      e.printStackTrace();
    }
    return num;
  }

  @Override
  @Transactional
  public int updateStoreInfo(Store store, int sid) {
    int num = 1;
    try {
      Store store1 = storeDao.getStoreById(sid);
      store1.setPhone(store.getPhone());
      store1.setStoreName(store.getStoreName());
      store1.setTypeConfig(store.getTypeConfig());

    } catch (Exception e) {
      num = 0;
      e.printStackTrace();
    }
    return num;
  }

  @Override
  @Transactional
  public Configuration getConfiguration(String value) {
    Configuration con = conDao.getConfiguration(value);
    return con;
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

  public ConfigurationDao getConDao() {
    return conDao;
  }

  public void setConDao(ConfigurationDao conDao) {
    this.conDao = conDao;
  }


}
