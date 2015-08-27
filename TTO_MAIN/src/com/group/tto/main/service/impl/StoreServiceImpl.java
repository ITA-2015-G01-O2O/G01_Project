package com.group.tto.main.service.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.StoreSearchCriteria;
import com.group.tto.main.dao.CollectDao;
import com.group.tto.main.dao.OrderDao;
import com.group.tto.main.dao.PoductDao;
import com.group.tto.main.dao.StoreDao;
import com.group.tto.main.service.StoreService;
import com.group.tto.main.vo.UserFavVendorsVo;
import com.group.tto.main.vo.MerProsList;


@Service
public class StoreServiceImpl implements StoreService {
  @Autowired
  private StoreDao store;
  @Autowired
  private OrderDao order;

  @Autowired
  private PoductDao productDao;
  @Autowired
  private CollectDao collectDao;

  @Override
  @Transactional
  public MerProsList getStoreById(Long sid) {
    Store temp = store.getStoreById(sid);
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
  public List<Product> getStoreByprosLabelId(long merId, Long productlabelId) {
    List<Product> storeList = productDao.getProductByCriteria(merId, productlabelId);
    return storeList;
  }

  @Override
  @Transactional
  public List<UserFavVendorsVo> getStoresByUserProfileId(Long userProfileId) {
    List<Store> storeList = new ArrayList<Store>();
    List<Collect> collectList = collectDao.findStoresByUserProfileId(userProfileId);
    for (Collect collect : collectList) {
      Store s = collect.getStore();
      storeList.add(s);
    }

    List<UserFavVendorsVo> userFavVendorsVoList = new ArrayList<UserFavVendorsVo>();
    for (Store s : storeList) {
      UserFavVendorsVo u = new UserFavVendorsVo();
      u.setStoreName(s.getStoreName());
      u.setServiceBeginTime(s.getServiceBeginTime());
      u.setServiceEndTime(s.getServiceEndTime());
      u.setLogoPicUrl(s.getLogoPicUrl());
      u.setDetailLocation(s.getDetailLocation());
      u.setPhone(s.getPhone());

      List<Order> orders = order.getAllOrderByStoreId(s.getStoreId());
      u.setAvgPoint(s.getAvgPoint());
      u.setOrderAmount(new BigDecimal(orders.size()));
      Long l = collectDao.findAllCollectsByStore(s);
      u.setCollectAmount(new BigDecimal(l));

      userFavVendorsVoList.add(u);


    }



    return userFavVendorsVoList;
  }

  @Override
  @Transactional
  public Store getOrgStoreById(Long sid) {
    return store.getStoreById(sid);
  }


}
