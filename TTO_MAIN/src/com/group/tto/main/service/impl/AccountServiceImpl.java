package com.group.tto.main.service.impl;

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
	public Account login(String loginname, String password) {
		return  this.accountDao.getBy(loginname, password);
	}

	@Override
	public Boolean contains(String loginname) {
		return this.accountDao.getCount(loginname) > 0;
	}

	@Override
	public void changePasswordByAccount(Account account, String newPassword) {
		try{
			Account a = accountDao.getAccountById(account.getAccountId());
			a.setPassword(newPassword);
		}catch(Exception e){
			e.printStackTrace();
		}
	}	

}
