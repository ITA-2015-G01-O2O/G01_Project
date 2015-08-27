package com.group.tto.main.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.CollectDao;
import com.group.tto.main.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService {
	
	@Autowired
	private CollectDao collectDao;
	

	@Override
	@Transactional
	public List<Collect> findAllCollects() {
		
		return collectDao.findAllCollects();
	}


	@Override
	@Transactional
	public Long findAllCollectsByStore(Store store) {
		
		return collectDao.findAllCollectsByStore(store);
	}


	@Override
	@Transactional
	public void removeCollectNodeById(Long id) {
		collectDao.removeCollectNodeById(id);
		
	}


	@Override
	@Transactional
	public void updateCollectNode(Collect c) {
		Collect cc =collectDao.findCollectNodeById(c.getCollectId());
		cc.setStore(null);
		cc.setUserProfileId(null);
	}

}
