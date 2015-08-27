package com.group.tto.main.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.AccountDao;
import com.group.tto.main.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	
	@Override
	@Transactional
	public Account login(String loginname, String password) {
		return  this.accountDao.getBy(loginname, password);
	}

	@Override
	@Transactional
	public Boolean contains(String loginname) {
		return this.accountDao.getCount(loginname) > 0;
	}

	@Override
	@Transactional
	public void changePasswordByAccount(Account account, String newPassword) {
		try{
			//Account a = accountDao.getAccountById(account.getAccountId());
		  account.setPassword(newPassword);
		  this.accountDao.updateAccount(account);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public Account getAccountByAccountId(Long accountId) {
		
		return accountDao.getAccountById(accountId);
	}

  @Override
  @Transactional
  public void register(String loginname, String password) {
      Account a=new Account();
      a.setUsername(loginname);
      a.setPassword(password);
      
      System.out.println("dao---======"+a.getUsername());
      System.out.println("dao---======"+a.getPassword());
      a.setIsDelete(false);
      a.setVersion(1l);
      UserProfile u=new UserProfile();
      u.setFund(new BigDecimal("0"));
      u.setIsDelete(false);
      u.setVersion(1L);
      a.setUserProfile(u);
      accountDao.createAccount(a);
    
  }	
	
	
	

}
