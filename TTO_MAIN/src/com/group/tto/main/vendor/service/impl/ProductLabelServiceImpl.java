package com.group.tto.main.vendor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.main.vendor.dao.ProductLabelDao;
import com.group.tto.main.vendor.service.ProductLabelService;

public class ProductLabelServiceImpl implements ProductLabelService {
	@Autowired
	private ProductLabelDao productLabelDao;

	@Override
	public List<ProductLabel> findAllProductLabels() {
		
		return productLabelDao.findAllProductLabels();
	}

	@Override
	public void addProductLabel(ProductLabel producatLabel) {
		productLabelDao.addProductLabel(producatLabel);
   
	}

}
