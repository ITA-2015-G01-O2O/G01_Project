package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.AccountDao;
import com.group.tto.main.vendor.dao.ConfigurationDao;
import com.group.tto.main.vendor.dao.LocationDao;
import com.group.tto.main.vendor.service.VendorRegisterService;

@Service
@Repository("vendorRegisterServiceImpl")
public class VendorRegisterServiceImpl implements VendorRegisterService {
  @Autowired
  private AccountDao accountDao;
  @Autowired
  private LocationDao locationDao;
  @Autowired
  private ConfigurationDao conDao;

  @Override
  @Transactional
  public int storeRegister(Store store, int uid) {
    int num = 1;
    try {
      Account account = accountDao.selectAccount(uid);
      account.setStore(store);
    } catch (Exception e) {
      num = 0;
      e.printStackTrace();
    }
    return num;
  }

  public AccountDao getAccountDao() {
    return accountDao;
  }

  public void setAccountDao(AccountDao accountDao) {
    this.accountDao = accountDao;
  }
 
  public LocationDao getLocationDao() {
    return locationDao;
  }

  public void setLocationDao(LocationDao locationDao) {
    this.locationDao = locationDao;
  }

  public ConfigurationDao getConDao() {
    return conDao;
  }

  public void setConDao(ConfigurationDao conDao) {
    this.conDao = conDao;
  }

  @Override
  @Transactional
  public int getLocation(String area, String place, String city) {
    int num=locationDao.getLocation(city, area, place);
    return num;
  }

  @Override
  @Transactional
  public Configuration getConfiguration(String value) {
    Configuration con=conDao.getConfiguration(value);
    return con;
  }

}
