package com.group.tto.main.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.type.ConfigName;
import com.group.tto.main.dao.ConfigurationDao;
import com.group.tto.main.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {

  @Autowired
  private ConfigurationDao dao;

  @Override
  @Transactional
  public String getValueByName(String name) {
    Configuration config = this.dao.getByName(name);
    return config == null ? null : config.getConfigValue();
  }

  @Override
  @Transactional
  public String getHotLine() {
    return this.getValueByName(ConfigName.SERIVCE_HOT_LINE.toString());
  }

}
