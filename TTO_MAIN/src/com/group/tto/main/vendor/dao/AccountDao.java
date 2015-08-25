package com.group.tto.main.vendor.dao;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;

public interface AccountDao {
  public Account selectAccount(int uid);
}
