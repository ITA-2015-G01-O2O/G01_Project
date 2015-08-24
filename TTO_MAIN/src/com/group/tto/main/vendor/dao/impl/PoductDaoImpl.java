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
import com.group.tto.main.vendor.dao.PoductDao;

@Repository
public class PoductDaoImpl extends BaseDao<Product> implements PoductDao {

	@Override
	public List<Product> findAllProducts(String id) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> product=query.from(Product.class);
		Predicate condition = builder.equal(product.get("STORE_ID"),id);
	    List <Product>products=this.getEntityManager().createQuery(query.where(condition)).getResultList();
		return products;
	}

	@Override
	public List<Product> findProductsByLabel(String label,String id) {
		
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> product=query.from(Product.class);
		
		Predicate condition = builder.equal(product.get("storeId"),id);
		builder.and(builder.equal(product.get("productLabel").get("productLabelName").as(String.class),label));
	    List <Product>products=this.getEntityManager().createQuery(query.where(condition)).getResultList();
		return products;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
