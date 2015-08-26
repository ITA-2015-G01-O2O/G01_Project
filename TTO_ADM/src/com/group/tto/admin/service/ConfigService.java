package com.group.tto.admin.service;

import java.util.List;

import com.group.tto.admin.vo.ConfigSearchVo;
import com.group.tto.cmn.model.Configuration;

public interface ConfigService {
  public List<Configuration> getAll();

  public void saveConfig(List<Configuration> configs);

  public String getValueByName(String name);
}
