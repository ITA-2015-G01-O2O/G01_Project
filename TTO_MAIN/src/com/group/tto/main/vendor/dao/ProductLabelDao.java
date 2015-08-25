package com.group.tto.main.vendor.dao;

import java.util.List;

import com.group.tto.cmn.model.ProductLabel;

public interface ProductLabelDao {
	public List<ProductLabel> findAllProductLabels();
	public void addProductLabel(ProductLabel producatLabel);
}
