package com.group.tto.main.service;

import java.util.List;

import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Store;

public interface CollectService {
	public List<Collect> findAllCollects();
	
	public Long findAllCollectsByStore(Store store);
	
	public void removeCollectNodeById(Long id);
	
	public void updateCollectNode(Collect c);
}
