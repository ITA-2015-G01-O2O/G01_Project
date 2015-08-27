package com.group.tto.main.vendor.service.impl;

import java.io.InputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.FileDao;
import com.group.tto.main.vendor.dao.AccountDao;
import com.group.tto.main.vendor.dao.ConfigurationDao;
import com.group.tto.main.vendor.dao.LocationDao;
import com.group.tto.main.vendor.service.VendorRegisterService;

@Service("vendorRegisterServiceImpl")
public class VendorRegisterServiceImpl implements VendorRegisterService {
  @Autowired
  private AccountDao accountDao;
  @Autowired
  private LocationDao locationDao;
  @Autowired
  private ConfigurationDao conDao;
  @Autowired
  private FileDao f;

  @Override
  @Transactional
  public int storeRegister(Store store, int uid, String uuid1, InputStream is1, String uuid2,
      InputStream is2) {
    int num = 1;
    try {
      Account account = accountDao.selectAccount(uid);
      f.saveFile(is1, uuid1);
      f.saveFile(is2, uuid2);
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

  public FileDao getF() {
    return f;
  }

  public void setF(FileDao f) {
    this.f = f;
  }

  @Override
  @Transactional
  public int getLocation(String area, String place, String city) {
    int num = locationDao.getLocation(city, area, place);
    return num;
  }

  @Override
  @Transactional
  public Configuration getConfiguration(String value) {
    Configuration con = conDao.getConfiguration(value);
    return con;
  }

  @Override
  public List<String> getAllArea() {
    List<String> locations = locationDao.getAllArea();
    return locations;
  }

  @Override
  public List<Configuration> getAllConfig() {
    List<Configuration> cons = conDao.getAllConfig();
    return cons;
  }

  @Override
  public List<String> getCity(String area) {
    List<String> locations = locationDao.getCity(area);
    return locations;
  }

  @Override
  public List<Location> getPlace(String city) {
    List<Location> locations = locationDao.getPlace(city);
    return locations;
  }

}
