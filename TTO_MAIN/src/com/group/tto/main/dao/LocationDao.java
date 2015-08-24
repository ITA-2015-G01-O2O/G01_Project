package com.group.tto.main.dao;

import java.util.List;

import com.group.tto.cmn.model.Location;

public interface LocationDao {
  /**
   * 查询所有的Location
   */
  public List<Location> getAllLocations();
  
}
