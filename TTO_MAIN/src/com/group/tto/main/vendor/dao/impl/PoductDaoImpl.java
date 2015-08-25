package com.group.tto.main.vendor.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import com.group.tto.cmn.model.Product;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.PoductDao;

@Repository("vendorPoductDaoImpl")
public class PoductDaoImpl extends BaseDao<Product> implements PoductDao {

	
	@Override
	public List<Product> findAllProducts(long sid) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> product=query.from(Product.class);
		Predicate condition =builder.and(builder.equal(product.get("storeId"),sid),builder.equal(product.get("isDelete"),0));
	    List <Product>products=this.getEntityManager().createQuery(query.where(condition)).getResultList();
		return products;
	}

	@Override
	public List<Product> findProductsByLabel(long labelId,long id) {
		
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> product=query.from(Product.class);
		
		Predicate condition =builder.and( builder.equal(product.get("storeId"),id),builder.equal(product.get("productLabel").get("PRO_LABEL_ID").as(long.class),labelId));
	    List <Product>products=this.getEntityManager().createQuery(query.where(condition)).getResultList();
		return products;
	}

	@Override
	public int updateProduct(Product product) {
		Product productTemp = this.getEntityManager().find(Product.class, product.getProductId());
		productTemp.setProductName(product.getProductName());
		productTemp.setPrice(product.getPrice());
	    this.update(productTemp);
		return 0;
	}

	@Override
	public int deleteProduct(long id) {
		Product productTemp = this.getEntityManager().find(Product.class, id);
		productTemp.setIsDelete(true);
		return 0;
	}

	@Override
	public void createProduct(Product product) {
		this.create(product);	
	}

}
