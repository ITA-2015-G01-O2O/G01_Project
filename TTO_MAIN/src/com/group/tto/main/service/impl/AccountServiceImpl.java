package com.group.tto.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.tto.cmn.model.Account;
import com.group.tto.main.dao.AccountDao;
import com.group.tto.main.service.AccountService;

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

}
