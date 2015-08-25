package com.group.tto.main.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.StoreSearchCriteria;
import com.group.tto.main.dao.StoreDao;
import com.group.tto.main.service.StoreService;


@Service
public class StoreServiceImpl implements StoreService {
  @Autowired
  private StoreDao store;


  @Override
  @Transactional
  public Store getStoreById(int sid) {
    return store.getStoreById(sid);
  }

  @Override
  @Transactional
  public List<Store> getStoresbyCriteria(StoreSearchCriteria criteria) {
    List<Store> storeList = store.getStoreByCriteria(criteria);
    return storeList;
  }


}
