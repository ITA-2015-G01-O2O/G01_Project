package com.group.tto.admin.dao;

import java.util.List;

import com.group.tto.cmn.model.Location;

public interface LocationDao {
  public List<Location> search(String area,String city,String place);
}
