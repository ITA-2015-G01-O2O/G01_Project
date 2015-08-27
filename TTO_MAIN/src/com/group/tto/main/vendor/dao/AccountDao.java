package com.group.tto.main.vendor.dao;

import com.group.tto.cmn.model.Account;

public interface AccountDao {
  public Account selectAccount(int uid);
}
