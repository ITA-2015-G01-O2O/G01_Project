package com.group.tto.admin.dao;

import com.group.tto.admin.cmn.UserSearchCriteria;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.cmn.model.Account;

public interface AccountDao {
  public PageDTO<Account> search(UserSearchCriteria searchCriteria);

  public void resetPassword(Long idl,String password);
}
