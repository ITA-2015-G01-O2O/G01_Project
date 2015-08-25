package com.group.tto.admin.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.admin.dao.BaseDao;
import com.group.tto.admin.dao.ConfigDao;
import com.group.tto.cmn.model.Admin;
import com.group.tto.cmn.model.Configuration;

@Repository
public class ConfigDaoImpl extends BaseDao<Configuration> implements ConfigDao {

  private static final String FIELD_CONFIG_NAME = "configName";

  @Override
  public List<Configuration> getAll() {
    return this.getEntityManager().createQuery("from Configuration").getResultList();
  }

  @Override
  public void save(Configuration configuration) {
    if (configuration.getConfigId() == null) {
      this.create(configuration);
    } else {
      this.update(configuration);
    }
  }

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

  @Override
  public Configuration get(Long id) {
    return this.getEntityManager().find(Configuration.class, id);
  }

}
