package com.group.tto.main.vendor.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.group.tto.cmn.model.Account;
import com.group.tto.main.vendor.dao.BaseDao;
import com.group.tto.main.vendor.dao.AccountDao;

public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

  @Override
  public Account selectAccount(Long uid) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Account> query = builder.createQuery(Account.class);
    Root<Account> ac = query.from(Account.class);

    Predicate condition = builder.equal(ac.get("accountId"), uid);
    Account account = this.getEntityManager().createQuery(query.where(condition)).getSingleResult();

    return account;
  }

}
