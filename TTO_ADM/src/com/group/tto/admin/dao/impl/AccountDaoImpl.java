package com.group.tto.admin.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.admin.cmn.UserSearchCriteria;
import com.group.tto.admin.dao.AccountDao;
import com.group.tto.admin.dao.BaseDao;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.cmn.model.Account;

@Repository
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

  private static final String FIELD_USERNAME = "username";
  private static final String FIELD_STORE = "store";


  @Override
  public PageDTO<Account> search(UserSearchCriteria searchCriteria) {
    PageDTO<Account> pageDTO = new PageDTO<Account>();

    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Account> query = builder.createQuery(Account.class);
    Root<Account> account = query.from(Account.class);

    Predicate predicate =
        builder.and(
            builder.like(account.get(FIELD_USERNAME).as(String.class),
                "%" + searchCriteria.getUserPhone() + "%"),
            searchCriteria.getIsVendor() ? builder.isNotNull(account.get(FIELD_STORE)) : builder
                .isNull(account.get(FIELD_STORE)));
    List<Account> result =
        this.getEntityManager().createQuery(query.where(predicate))
            .setFirstResult(searchCriteria.getStart().intValue())
            .setMaxResults(searchCriteria.getLimit().intValue()).getResultList();

    pageDTO.setLimit(searchCriteria.getLimit());
    pageDTO.setStart(searchCriteria.getStart());
    pageDTO.setTotal(this.getTotal(searchCriteria));
    pageDTO.setDatas(result);

    return pageDTO;
  }

  @Override
  public void resetPassword(Long id, String password) {
    Account account = this.getEntityManager().find(Account.class, id);
    account.setPassword(password);
    this.update(account);
  }

  private Long getTotal(UserSearchCriteria searchCriteria) {
    CriteriaBuilder critBuilder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Long> critQuery = critBuilder.createQuery(Long.class);
    Root<Account> root = critQuery.from(Account.class);

    Predicate predicate =
        critBuilder.and(critBuilder.like(root.get(FIELD_USERNAME).as(String.class), "%"
            + searchCriteria.getUserPhone() + "%"),
            searchCriteria.getIsVendor()
                ? critBuilder.isNotNull(root.get(FIELD_STORE))
                : critBuilder.isNull(root.get(FIELD_STORE)));

    return this.getEntityManager()
        .createQuery(critQuery.select(critBuilder.countDistinct(root)).where(predicate))
        .getSingleResult();
  }

}
