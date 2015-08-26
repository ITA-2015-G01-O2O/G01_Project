package com.group.tto.main.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.cmn.type.StopProfileStatus;
import com.group.tto.main.common.Constants;
import com.group.tto.main.common.StoreSearchCriteria;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.StoreDao;


@Repository
public class StoreDaoImpl extends BaseDao<Store> implements StoreDao {

  private static final String FIELD_STOREID = "storeId";
  private static final String FIELD_STOREPLACE = "location";
  private static final String FIELD_STATUS = "status";
  private static final String FIELD_STORE_PROFILE = "storeProfile";

  @Override
  // 根据商家id找到商家
  // 根据商家id找到商家
  public Store getStoreById(Long sid) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Store> query = builder.createQuery(Store.class);
    Root<Store> store = query.from(Store.class);


    Predicate condition = builder.equal(store.get(FIELD_STOREID), sid);
    Store store1 =

    this.getEntityManager().createQuery(query.where(condition)).getResultList().get(0);
    return store1;
  }

  @Override
  public List<Store> getStoreByCriteria(StoreSearchCriteria criteria) {

    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Store> query = builder.createQuery(Store.class);
    Root<Store> store = query.from(Store.class);

    Predicate condition =
        builder.and(builder.equal(store.get(FIELD_STOREPLACE), criteria.getStoreLocation()),
            builder.equal(store.get(FIELD_STORE_PROFILE).get(FIELD_STATUS).as(String.class),
                StopProfileStatus.NORMAL.toString()));

    List<Store> storeList =
        this.getEntityManager().createQuery(query.where(condition)).getResultList();

    return storeList;
  }


}
