package com.group.tto.main.service.impl;


import java.util.ArrayList;
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
import com.group.tto.main.vo.StoreSearchVo;


@Service
public class StoreServiceImpl implements StoreService {
  @Autowired
  private StoreDao store;

  @Autowired
  private PoductDao productDao;
  
  @Override
  @Transactional
	public Store getStoreById(Long sid) {	
    return store.getStoreById(sid);
  }

  @Override
  @Transactional
  public List<StoreSearchVo> getStoresbyCriteria(StoreSearchCriteria criteria) {
    List<Store> storeList = store.getStoreByCriteria(criteria);
    List<StoreSearchVo> voList = new ArrayList<StoreSearchVo>();
    for(Store store:storeList){
      voList.add(new StoreSearchVo(store));
    }
    return voList;
  }

  @Override
  @Transactional
  public  List<Product> getStoreByprosLabelId(long merId, Long productlabelId) {
    List<Product> storeList = productDao.getProductByCriteria(merId ,productlabelId);
    return storeList;
  }


}
