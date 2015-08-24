package com.group.tto.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.cmn.UserSearchCriteria;
import com.group.tto.admin.dao.AccountDao;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.admin.service.UserService;
import com.group.tto.cmn.model.Account;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private AccountDao accountDao;

  @Override
  public PageDTO<Account> get(UserSearchCriteria searchCriteria) {
    return this.accountDao.search(searchCriteria);
  }

  @Override
  public void resetPassword(Long id) {
    this.accountDao.resetPassword(id);
  }

}
