package com.group.tto.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.StoreSearchCriteria;


public interface StoreService {
	public Store getStoreById(Long sid);

  public List<Store> getStoresbyCriteria(StoreSearchCriteria criteria);

  public  List<Product> getStoreByprosLabelId(long merId, Long productlabelId);
}
