package com.group.tto.main.dao;

import com.group.tto.cmn.model.Account;

public interface AccountDao {
	public Account getBy(String loginname, String password);

	  public Integer getCount(String loginname);
}
