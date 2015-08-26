package com.group.tto.main.dao;

import com.group.tto.cmn.model.Configuration;

public interface ConfigurationDao {
  public Configuration getByName(String name);
}
