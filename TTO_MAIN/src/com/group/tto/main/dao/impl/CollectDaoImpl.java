/**
 * 
 */
package com.group.tto.main.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.Order;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.CollectDao;

/**
 * @author LINI5
 *
 */
@Repository
public class CollectDaoImpl  extends BaseDao<Collect> implements CollectDao {
	
	
	private static final String FIELD_STORE="store";
	private static final String FIELD_COLLECTID="collectId";

	@Override
	public List<Collect> findAllCollects() {
		List<Collect> collects = new ArrayList<Collect>();
	
		collects = this.getEntityManager().createQuery("from Collect")
				.getResultList();

		return collects;
	}

	@Override
	public Long findAllCollectsByStore(Store store) {
		
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<Collect> collect = query.from(Collect.class);

		Predicate condition = builder.equal(collect.get(FIELD_STORE),
				store);	
		 return this.getEntityManager()
			        .createQuery(query.select(builder.countDistinct(collect)).where(condition))
			        .getSingleResult();
	}

	@Override
	public void removeCollectNodeById(Long id) {
		delete(this.getEntityManager().find(Collect.class, id));
	}

	@Override
	public Collect findCollectNodeById(Long id) {
		
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Collect> query = builder.createQuery(Collect.class);
		Root<Collect> collect = query.from(Collect.class);

		Predicate condition = builder.equal(collect.get(FIELD_COLLECTID),
				id);	
		 return this.getEntityManager()
			        .createQuery(query.where(condition))
			        .getSingleResult();
	}

  @Override
  public void addCollect(Collect c) {
    try {
      this.create(c);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

	
	

}
