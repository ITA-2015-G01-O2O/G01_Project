package com.group.tto.main.vendor.dao;

import java.util.List;

import com.group.tto.cmn.model.Location;

public interface LocationDao {
  public Location selectLocation(int sid);

  public int getLocation(String city, String area, String place);
  
  public List<String> getAllArea();
  
  public List<String> getCity(String area);
  
  public List<Location> getPlace(String city);
}
