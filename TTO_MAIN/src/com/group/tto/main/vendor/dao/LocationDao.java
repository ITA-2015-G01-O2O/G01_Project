package com.group.tto.main.vendor.dao;

import com.group.tto.cmn.model.Location;

public interface LocationDao {
  public Location selectLocation(int sid);

  public int getLocation(String city, String area, String place);
}
