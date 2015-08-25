package com.group.tto.admin.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.admin.dao.AdminDao;
import com.group.tto.admin.dao.BaseDao;
import com.group.tto.cmn.model.Admin;

@Repository
public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {

  private static final String FIELD_LOGINNAME = "loginname";
  private static final String FIELD_PASSWORD = "password";

  public Admin getBy(String loginname, String password) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
    Root<Admin> admin = query.from(Admin.class);

    Predicate predicate =
        builder.and(builder.equal(admin.get(FIELD_LOGINNAME), loginname),
            builder.equal(admin.get(FIELD_PASSWORD), password));
    List<Admin> result =
        this.getEntityManager().createQuery(query.where(predicate)).getResultList();

    return result.size() == 0 ? null : result.get(0);
  }

  @Override
  public Integer getCount(String loginname) {
    CriteriaBuilder critBuilder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Long> critQuery = critBuilder.createQuery(Long.class);
    Root<Admin> root = critQuery.from(Admin.class);

    Predicate predicate =critBuilder.equal(root.get(FIELD_LOGINNAME), loginname);
    
    int count =
        this.getEntityManager().createQuery(critQuery.select(critBuilder.countDistinct(root)).where(predicate))
            .getSingleResult().intValue();

    return count;
  }

}
