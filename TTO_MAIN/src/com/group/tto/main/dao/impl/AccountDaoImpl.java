package com.group.tto.main.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Admin;
import com.group.tto.cmn.model.Order;
import com.group.tto.main.dao.AccountDao;
import com.group.tto.main.dao.BaseDao;

@Repository
public class AccountDaoImpl extends BaseDao<Account> implements  AccountDao{
	 private static final String FIELD_LOGINNAME = "username";
	  private static final String FIELD_PASSWORD = "password";
	  private static final String FIELD_ACCOUNTID="accountId";
	@Override
	public Account getBy(String loginname, String password) {
		 CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		    CriteriaQuery<Account> query = builder.createQuery(Account.class);
		    Root<Account> admin = query.from(Account.class);

		    Predicate predicate =
		        builder.and(builder.equal(admin.get(FIELD_LOGINNAME), loginname),
		            builder.equal(admin.get(FIELD_PASSWORD), password));
		    
		    
		    List<Account> result =
		        this.getEntityManager().createQuery(query.where(predicate)).getResultList();

		    return result.size() == 0 ? null : result.get(0);
		
	}

	@Override
	public Integer getCount(String loginname) {
		 CriteriaBuilder critBuilder = this.getEntityManager().getCriteriaBuilder();
		    CriteriaQuery<Account> critQuery = critBuilder.createQuery(Account.class);
		    Root<Account> root = critQuery.from(Account.class);

		    Predicate predicate =critBuilder.equal(root.get(FIELD_LOGINNAME), loginname);
		    
			    List<Account> result =
			        this.getEntityManager().createQuery(critQuery.where(predicate)).getResultList();

		    return result.size()>0?1:0;
	}

	@Override
	public Account getAccountById(Long accountId) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Account> query = builder.createQuery(Account.class);
		Root<Account> account1 = query.from(Account.class);
		Predicate condition = builder.equal(account1.get(FIELD_ACCOUNTID), accountId);	
		Account account2 = this.getEntityManager().createQuery(query.where(condition)).getResultList().get(0);
		return account2;
		
	}

  @Override
  public void createAccount(Account a) {
      try {
        this.create(a);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  }
	
	
	

}
