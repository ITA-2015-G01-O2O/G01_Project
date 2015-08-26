package com.group.tto.main.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Product;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.PoductDao;


@Repository
public class PoductDaoImpl extends BaseDao<Product> implements PoductDao {

  private static final String FIELD_STORE_PRODUCTLABELS = "productLabel";
  private static final String FIELD_STORE_PRODUCTLABELID = "productLabelId";
  private static final String FIELD_STOREID = "storeId";
  @Override
  public List<Product> getProductByCriteria(Long merId, Long productlabelId) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Product> query = builder.createQuery(Product.class);
    Root<Product> root = query.from(Product.class);

    Predicate condition =
        builder.and(builder.equal(root.get(FIELD_STOREID), merId), builder.equal(
            root.get(FIELD_STORE_PRODUCTLABELS).get(FIELD_STORE_PRODUCTLABELID).as(Long.class), productlabelId));
    List<Product> productsList =
        this.getEntityManager().createQuery(query.where(condition)).getResultList();
    
    return productsList;
  }
  
  
}
