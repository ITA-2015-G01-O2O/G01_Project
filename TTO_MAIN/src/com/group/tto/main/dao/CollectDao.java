package com.group.tto.main.dao;

import java.util.List;

import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Store;

public interface CollectDao {
	
	public List<Collect> findAllCollects();
	
	public Long findAllCollectsByStore(Store store);
	
	public void removeCollectNodeById(Long id);
	
	public Collect findCollectNodeById(Long id);
	
    public void addCollect(Collect c);
}
