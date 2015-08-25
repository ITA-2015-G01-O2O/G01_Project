package com.group.tto.main.vendor.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.StoreDao;

@Repository("vendorStoreDaoImpl")
public class StoreDaoImpl extends BaseDao<Store> implements StoreDao {

  @Override
  public Store getStoreById(int sid) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Store> query = builder.createQuery(Store.class);
    Root<Store> store = query.from(Store.class);

    Predicate condition = builder.equal(store.get("storeId"), sid);
    Store store1 = this.getEntityManager().createQuery(query.where(condition)).getSingleResult();
    return store1;
  }

}
