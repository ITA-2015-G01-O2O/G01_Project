package com.group.tto.admin.service;

import com.group.tto.admin.cmn.ShopSearchCriteria;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.cmn.model.Store;

public interface ShopService {
  public PageDTO<Store> search(ShopSearchCriteria searchCriteria);

  public Store get(Long id);

  public void activeStore(Long id);

  public void inactiveStore(Long id);

  public void setHot(Long id);
  
  public void setNoHot(Long id);
  
  public Long getTotalOfCheck();
}
