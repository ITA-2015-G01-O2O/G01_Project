package com.group.tto.main.vendor.dao;

import java.util.List;

import com.group.tto.cmn.model.Configuration;

public interface ConfigurationDao {
  public Configuration getConfiguration(String value);

  public List<Configuration> getAllConfig();
}
