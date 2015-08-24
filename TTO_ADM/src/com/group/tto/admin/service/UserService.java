package com.group.tto.admin.service;

import com.group.tto.admin.cmn.UserSearchCriteria;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.cmn.model.Account;

public interface UserService {
  public PageDTO<Account> get(UserSearchCriteria searchCriteria);

  public String resetPassword(Long id);
  
  public String resetPassword(Long id, String newPassword);
}
