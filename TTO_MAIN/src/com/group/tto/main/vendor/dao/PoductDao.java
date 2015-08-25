package com.group.tto.main.vendor.dao;

import java.util.List;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;

public interface PoductDao {
	 public void createProduct(Product product);
	 public List<Product> findAllProducts(long sid);
	 public List<Product> findProductsByLabel(long labelId,long sid);
	 public int updateProduct(Product product);
	 public int deleteProduct(long pid);
}
