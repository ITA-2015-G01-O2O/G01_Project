package com.group.tto.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.cmn.ServiceInfoPool;
import com.group.tto.admin.dao.ConfigDao;
import com.group.tto.admin.service.ConfigService;
import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.type.ConfigName;

@Service
public class ConfigServiceImpl implements ConfigService {

  @Autowired
  private ConfigDao configDao;

  @Override
  @Transactional
  public List<Configuration> getAll() {
    return this.configDao.getAll();
  }

  @Override
  @Transactional
  public void saveConfig(List<Configuration> configs) {
    for (Configuration config : configs) {
      Configuration dbConfig = null;
      if (config.getConfigName().equals(ConfigName.CATEGORY_NAME.name())) {
        if (config.getConfigId() != null) {
          dbConfig = this.configDao.get(config.getConfigId());
        }
      } else {
        dbConfig = this.configDao.getByName(config.getConfigName());
      }
      if (dbConfig == null) {
        dbConfig = config;
      } else {
        dbConfig.setConfigValue(config.getConfigValue());
      }
      dbConfig.toString();
      this.configDao.save(dbConfig);
      if (dbConfig.getConfigName().equals(ConfigName.AUTO_CONFIRM_TIME.toString())) {
        ServiceInfoPool.addAttribute(ConfigName.AUTO_CONFIRM_TIME.toString(),
            dbConfig.getConfigValue());
      } else if (dbConfig.getConfigName().equals(ConfigName.AUTO_CANCEL_TIME.toString())) {
        ServiceInfoPool.addAttribute(ConfigName.AUTO_CANCEL_TIME.toString(),
            dbConfig.getConfigValue());
      }
    }
  }

  @Override
  @Transactional
  public String getValueByName(String name) {
    Configuration config = this.configDao.getByName(name);
    return config == null ? null : config.getConfigValue();
  }

}
