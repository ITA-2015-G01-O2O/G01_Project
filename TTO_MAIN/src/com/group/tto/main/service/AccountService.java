package com.group.tto.main.service;

import com.group.tto.cmn.model.Account;


public interface AccountService {
	
	 public Account login(String loginname, String password); 
	 public Boolean contains(String loginname);
	public void changePasswordByAccount(Account account,String newPassword);
	public Account getAccountByAccountId(Long accountId);
	 public void register(String loginname, String password); 
}
