package com.group.tto.admin.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.cmn.UserSearchCriteria;
import com.group.tto.admin.dao.AccountDao;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.admin.service.UserService;
import com.group.tto.cmn.model.Account;

@Service
public class UserServiceImpl implements UserService {
  private static final String INIT_PSW = "Password1";

  @Autowired
  private AccountDao accountDao;

  @Override
  @Transactional
  public PageDTO<Account> get(UserSearchCriteria searchCriteria) {
    return this.accountDao.search(searchCriteria);
  }

  @Override
  @Transactional
  public String resetPassword(Long id) {
    this.accountDao.resetPassword(id, INIT_PSW);
    return INIT_PSW;
  }

  @Override
  @Transactional
  public String resetPassword(Long id, String newPassword) {
    this.accountDao.resetPassword(id, newPassword);
    return newPassword;
  }

}
