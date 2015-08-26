package com.group.tto.main.vendor.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.type.ConfigName;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.ConfigurationDao;

@Repository
public class VendorConfigurationDaoImpl extends BaseDao<Configuration> implements ConfigurationDao {

  @Override
  public Configuration getConfiguration(String value) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Configuration> query = builder.createQuery(Configuration.class);
    Root<Configuration> ac = query.from(Configuration.class);

    Predicate condition = builder.equal(ac.get("configValue"), value);
    Configuration con =
        this.getEntityManager().createQuery(query.where(condition)).getSingleResult();
    return con;
  }

  @Override
  public List<Configuration> getAllConfig() {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Configuration> query = builder.createQuery(Configuration.class);
    Root<Configuration> ac = query.from(Configuration.class);

    Predicate condition = builder.equal(ac.get("configName"), ConfigName.CATEGORY_NAME.toString());
    List<Configuration> cons =
        this.getEntityManager().createQuery(query.where(condition)).getResultList();
    return cons;
  }

}
