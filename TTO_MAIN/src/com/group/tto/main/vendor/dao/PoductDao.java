package com.group.tto.main.vendor.dao;

import java.util.List;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;

public interface PoductDao {
	 public List<Product> findAllProducts(String id);
	 public List<Product> findProductsByLabel(String label,String id);
	 public int updateProduct(Product product);
	 public int deleteProduct(int id);
}
