package com.group.tto.main.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.StoreSearchCriteria;
import com.group.tto.main.dao.PoductDao;
import com.group.tto.main.dao.StoreDao;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.vo.MerProsList;


@Service
public class StoreServiceImpl implements StoreService {
  @Autowired
  private StoreDao store;

  @Autowired
  private PoductDao productDao;
  
  @Override
  @Transactional
	public MerProsList getStoreById(Long sid) {
    Store temp=store.getStoreById(sid);
    if (temp == null) {
      temp = new Store();
    }
    System.out.println(temp.getProducts().size());
    MerProsList merProsList = new MerProsList(temp);
    return merProsList;
  }

  @Override
  @Transactional
  public List<Store> getStoresbyCriteria(StoreSearchCriteria criteria) {
    List<Store> storeList = store.getStoreByCriteria(criteria);
    return storeList;
  }

  @Override
  @Transactional
  public  List<Product> getStoreByprosLabelId(long merId, Long productlabelId) {
    List<Product> storeList = productDao.getProductByCriteria(merId ,productlabelId);
    return storeList;
  }


}
