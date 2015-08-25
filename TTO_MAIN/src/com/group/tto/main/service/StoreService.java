package com.group.tto.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.StoreSearchCriteria;


public interface StoreService {
  public Store getStoreById(int sid);

  public List<Store> getStoresbyCriteria(StoreSearchCriteria criteria);
}
