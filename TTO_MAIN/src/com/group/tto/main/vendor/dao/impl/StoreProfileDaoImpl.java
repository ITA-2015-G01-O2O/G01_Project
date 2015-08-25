package com.group.tto.main.vendor.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.model.StoreProfile;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.StoreProfileDao;
@Repository("vendorStoreProfileDaoImpl")
public class StoreProfileDaoImpl extends BaseDao<StoreProfile> implements StoreProfileDao {

  @Override
  public StoreProfile selectStoreProfile(int sid) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Store> query = builder.createQuery(Store.class);
    Root<Store> store = query.from(Store.class);

    Predicate condition = builder.equal(store.get("storeId"), sid);
    Store store1 = this.getEntityManager().createQuery(query.where(condition)).getSingleResult();
    StoreProfile sp=store1.getStoreProfile();
    return sp;
    
  }

}
