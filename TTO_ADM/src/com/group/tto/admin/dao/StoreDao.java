package com.group.tto.admin.dao;

import com.group.tto.admin.cmn.ShopSearchCriteria;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.cmn.model.Store;

public interface StoreDao {
  public PageDTO<Store> search(ShopSearchCriteria searchCriteria);

  public Store getById(Long id);
  
  public void save(Store store);
}
