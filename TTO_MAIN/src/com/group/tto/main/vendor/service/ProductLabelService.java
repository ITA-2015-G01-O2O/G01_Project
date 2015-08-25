package com.group.tto.main.vendor.service;

import java.util.List;

import com.group.tto.cmn.model.ProductLabel;

public interface ProductLabelService {
	public List<ProductLabel> findAllProductLabels();
	public void addProductLabel(ProductLabel producatLabel);
}
