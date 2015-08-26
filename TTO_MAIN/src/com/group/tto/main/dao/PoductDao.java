package com.group.tto.main.dao;

import java.util.List;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;

public interface PoductDao {
  public List<Product> getProductByCriteria(Long merId, Long productlabelId);
}
