package com.group.tto.admin.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.cmn.ShopSearchCriteria;
import com.group.tto.admin.dao.StoreDao;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.admin.service.ShopService;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.type.StopProfileStatus;

@Service
public class ShopServiceImpl implements ShopService {
  @Autowired
  private StoreDao dao;

  @Override
  @Transactional
  public PageDTO<Store> search(ShopSearchCriteria searchCriteria) {
    return this.dao.search(searchCriteria);
  }

  @Override
  @Transactional
  public Store get(Long id) {
    return this.dao.getById(id);
  }

  @Override
  @Transactional
  public void activeStore(Long id) {
    Store store = this.dao.getById(id);
    store.getStoreProfile().setStatus(StopProfileStatus.NORMAL.toString());
    this.dao.save(store);
  }

  @Override
  @Transactional
  public void inactiveStore(Long id) {
    Store store = this.dao.getById(id);
    store.getStoreProfile().setStatus(StopProfileStatus.FREEZE.toString());
    this.dao.save(store);
  }

  @Override
  @Transactional
  public void setHot(Long id) {
    Store store = this.dao.getById(id);
    store.setIsHot(true);
    this.dao.save(store);
  }
  
  @Override
  @Transactional
  public void setNoHot(Long id) {
    Store store = this.dao.getById(id);
    store.setIsHot(false);
    this.dao.save(store);
  }

  @Override
  @Transactional
  public Long getTotalOfCheck() {
    return this.dao.getTotalOf(StopProfileStatus.CHECK.name());
  }

}
