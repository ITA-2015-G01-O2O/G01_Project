package com.group.tto.admin.dao;

import com.group.tto.cmn.model.Admin;

public interface AdminDao {
  public Admin getBy(String loginname, String password);

  public Integer getCount(String loginname);
}
