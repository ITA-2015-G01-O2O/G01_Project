package com.group.tto.main.vendor.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.ProductLabel;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.ProductLabelDao;

@Repository("vendorProductLabelDaoImpl")
public class ProductLabelDaoImpl extends BaseDao<ProductLabel> implements
		ProductLabelDao {

	@Override
	public List<ProductLabel> findAllProductLabels() {
		System.out.println(this.getEntityManager().getCriteriaBuilder());
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		@SuppressWarnings("unchecked")
		List<ProductLabel> productLabels = this.getEntityManager()
				.createQuery("from ProductLabel").getResultList();
		return productLabels;

	}

	@Override
	public void addProductLabel(ProductLabel producatLabel) {
		this.create(producatLabel);
	}

	@Override
	public ProductLabel findProductLabel(long labelID) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ProductLabel> query = builder.createQuery(ProductLabel.class);
		Root<ProductLabel> productLabel=query.from(ProductLabel.class);
		Predicate condition = builder.equal(productLabel.get("productLabelId"),labelID);
	    List <ProductLabel>productLabelTemp=this.getEntityManager().createQuery(query.where(condition)).getResultList();
		return productLabelTemp.get(0);
	}

}
