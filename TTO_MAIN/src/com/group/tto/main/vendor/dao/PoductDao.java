package com.group.tto.main.vendor.dao;

import java.util.List;
import com.group.tto.cmn.model.Product;

public interface PoductDao {
	 public List<Product> findAllProducts();
	 public List<Product> findProductsByLabel(String label);
	 public int updateProduct(Product product);
	 public int deleteProduct(int id);
}
