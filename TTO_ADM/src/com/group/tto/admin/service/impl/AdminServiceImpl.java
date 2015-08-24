package com.group.tto.admin.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.dao.AdminDao;
import com.group.tto.admin.service.AdminService;
import com.group.tto.cmn.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  private AdminDao adminDao;

  @Override
  @Transactional
  public Admin login(String loginname, String password) {
    return this.adminDao.getBy(loginname, password);
  }

  @Override
  @Transactional
  public Boolean contains(String loginname) {
    return this.adminDao.getCount(loginname) > 0;
  }

  public AdminDao getAdminDao() {
    return adminDao;
  }

  public void setAdminDao(AdminDao adminDao) {
    this.adminDao = adminDao;
  }



}
