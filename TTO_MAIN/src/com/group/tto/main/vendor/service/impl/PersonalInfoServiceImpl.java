package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.main.vendor.dao.StoreProfileDao;
import com.group.tto.main.vendor.service.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
  @Autowired
  private StoreProfileDao storeProfileDao;

  @Override
  @Transactional
  public StoreProfile loadPersonInfo(int sid) {
    StoreProfile sp = storeProfileDao.selectStoreProfile(sid);

    return sp;
  }

  public StoreProfileDao getStoreProfileDao() {
    return storeProfileDao;
  }

  public void setStoreProfileDao(StoreProfileDao storeProfileDao) {
    this.storeProfileDao = storeProfileDao;
  }

}
