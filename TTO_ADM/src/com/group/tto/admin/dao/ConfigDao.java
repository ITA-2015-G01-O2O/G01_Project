package com.group.tto.admin.dao;

import java.util.List;

import com.group.tto.cmn.model.Configuration;

public interface ConfigDao {
  public List<Configuration> getAll();

  public void save(Configuration configuration);

  public Configuration getByName(String name);
  
  public Configuration get(Long id);
  
}
