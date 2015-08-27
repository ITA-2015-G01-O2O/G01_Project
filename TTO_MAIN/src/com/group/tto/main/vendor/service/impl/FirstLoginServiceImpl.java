package com.group.tto.main.vendor.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.vendor.dao.AccountDao;
import com.group.tto.main.vendor.service.FirstLoginService;

@Service
@Repository
public class FirstLoginServiceImpl implements FirstLoginService {
  @Autowired
  private AccountDao accountDao;

  @Override
  @Transactional
  public Store getStore(int uid) {
    Account account = accountDao.selectAccount(uid);
    Store store = account.getStore();
    return store;
  }

  public AccountDao getAccountDao() {
    return accountDao;
  }

  public void setAccountDao(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

}
