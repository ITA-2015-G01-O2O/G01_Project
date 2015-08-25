package com.group.tto.main.vendor.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.ProductLabel;
@Repository("vendorProductLabelService")
public interface ProductLabelService {
	public List<ProductLabel> findAllProductLabels();
	public void addProductLabel(ProductLabel producatLabel);
}
