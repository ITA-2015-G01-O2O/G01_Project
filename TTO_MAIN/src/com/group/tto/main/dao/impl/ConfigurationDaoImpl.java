package com.group.tto.main.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.ConfigurationDao;

@Repository
public class ConfigurationDaoImpl  extends BaseDao<Configuration> implements ConfigurationDao {

  private static final String FIELD_CONFIG_NAME = "configName";
  
  @Override
  public Configuration getByName(String name) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Configuration> query = builder.createQuery(Configuration.class);
    Root<Configuration> admin = query.from(Configuration.class);

    Predicate predicate = builder.equal(admin.get(FIELD_CONFIG_NAME), name);
    List<Configuration> result =
        this.getEntityManager().createQuery(query.where(predicate)).getResultList();

    return result.size() == 0 ? null : result.get(0);
  }

}
