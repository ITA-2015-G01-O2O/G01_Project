package com.group.tto.main.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Account;
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
			Account a = accountDao.getAccountById(account.getAccountId());
			a.setPassword(newPassword);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public Account getAccountByAccountId(Long accountId) {
		
		return accountDao.getAccountById(accountId);
	}	
	
	
	

}
