package com.group.tto.main.service;

import java.util.List;

import com.group.tto.cmn.model.Location;

public interface LocationService {
  public List<Location> search(String search, String splitor,Integer limit);

  public List<Location> search(String area, String city, String place,Integer limit);
}
