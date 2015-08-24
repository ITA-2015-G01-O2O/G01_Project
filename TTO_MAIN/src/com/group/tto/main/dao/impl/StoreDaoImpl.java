package com.group.tto.main.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.StoreDao;

public class StoreDaoImpl extends BaseDao<Store> implements StoreDao {
	
	private static final String FIELD_STOREID = "storeId";

	@Override
	public Store getStoreById(int sid) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Store> query = builder.createQuery(Store.class);
		Root<Store> store = query.from(Store.class);
		
		Predicate condition = builder.equal(store.get(FIELD_STOREID), sid);		
		Store store1 = this.getEntityManager().createQuery(query.where(condition)).getResultList().get(0);
		
		return store1;
	}

}
