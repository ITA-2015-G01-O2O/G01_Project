package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.AccountDao;
import com.group.tto.main.vendor.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
  @Autowired
  private AccountDao accountDao;

  @Override
  @Transactional
  public int storeRegister(Store store, int uid) {
    int num = 1;
    try {
      Account account = accountDao.selectAccount(uid);
      account.setStore(store);
    } catch (Exception e) {
      num = 0;
      e.printStackTrace();
    }
    return num;
  }

  public AccountDao getAccountDao() {
    return accountDao;
  }

  public void setAccountDao(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

}
