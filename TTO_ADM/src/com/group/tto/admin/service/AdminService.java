package com.group.tto.admin.service;

import com.group.tto.cmn.model.Admin;

public interface AdminService {
  public Admin login(String loginname, String password);

  public Boolean contains(String loginname);
}
