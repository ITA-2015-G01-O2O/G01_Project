package com.group.tto.main.vendor.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.ConfigurationDao;

public class VendorConfigurationDaoImpl extends BaseDao<Configuration> implements ConfigurationDao {

  @Override
  public Configuration getConfiguration(String value) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Configuration> query = builder.createQuery(Configuration.class);
    Root<Configuration> ac = query.from(Configuration.class);

    Predicate condition = builder.equal(ac.get("configValue"), value);
    Configuration con = this.getEntityManager().createQuery(query.where(condition)).getSingleResult();
    return con;
  }

}
