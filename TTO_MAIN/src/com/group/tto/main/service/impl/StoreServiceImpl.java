package com.group.tto.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.StoreDao;

@Service
public class StoreServiceImpl {
	@Autowired
	private StoreDao storeDao;
	
	private Store getAllProsById(int merId){
		return storeDao.getStoreById(merId);
	}
}
