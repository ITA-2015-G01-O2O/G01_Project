package com.group.tto.main.vendor.service;

import com.group.tto.cmn.model.Store;

public interface BasicSettingService {
  public void updateBasicSetting(int sid, Store store);

  public Store loadBasicSetting(int sid);
}
