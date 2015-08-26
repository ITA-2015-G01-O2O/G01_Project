package com.group.tto.main.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.Constants;
import com.group.tto.main.common.StoreSearchCriteria;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.StoreDao;


@Repository
public class StoreDaoImpl extends BaseDao<Store> implements StoreDao {

  private static final String FIELD_STOREID = "storeId";
  private static final String FIELD_STOREPLACE = "location";

  @Override
  // 根据商家id找到商家
	//根据商家id找到商家
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

    Predicate condition = builder.equal(store.get(FIELD_STOREPLACE), criteria.getStoreLocation());

    if (Constants.ASC.equals(criteria.getOrderType())) {
      query = query.orderBy(builder.asc(store.get(criteria.getSortType())));
    }
    if (Constants.DESC.equals(criteria.getOrderType())) {
      query = query.orderBy(builder.desc(store.get(criteria.getSortType())));
    }
    if (criteria.getStoreType() != null || criteria.getSortType() != null) {
      condition =
          builder.and(condition,
              builder.equal(store.get("typeConfig").get("configValue"), criteria.getStoreType()));
    }

    List<Store> storeList =
        this.getEntityManager().createQuery(query.where(condition)).getResultList();

    return storeList;
  }

}
