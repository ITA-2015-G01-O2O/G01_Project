package com.group.tto.main.vendor.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.ProductLabelDao;

public class ProductLabelDaoImpl extends BaseDao<ProductLabel> implements
		ProductLabelDao {

	@Override
	public List<ProductLabel> findAllProductLabels() {
		System.out.println(this.getEntityManager().getCriteriaBuilder());
		CriteriaBuilder builder =this.getEntityManager().getCriteriaBuilder();
		@SuppressWarnings("unchecked")
		List<ProductLabel> productLabels = this.getEntityManager().createQuery("from ProductLabel").getResultList();
		return productLabels;

	}

	@Override
	public void addProductLabel(ProductLabel producatLabel)
	{
		this.create(producatLabel);
	}

}
