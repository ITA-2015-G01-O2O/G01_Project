package com.group.tto.main.dao;

import java.util.List;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.StoreSearchCriteria;

public interface StoreDao {
	public Store getStoreById(Long sid);

	
	
	
	/**
	 * query store by criteria
	 * @param criteria
	 * @return
	 */
	public List<Store> getStoreByCriteria(StoreSearchCriteria criteria);

	
}
