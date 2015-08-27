package com.group.tto.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Location;
import com.group.tto.main.dao.LocationDao;
import com.group.tto.main.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationDao locationDao;

  @Override
  public List<Location> search(String search, String splitor,Integer limit) {
    String[] searchs = search.split(splitor);
    if (searchs.length == 1) {
      return this.locationDao.search(searchs[0],limit);
    } else if (searchs.length == 2) {
      return this.search(searchs[0], searchs[1], "",limit);
    } else if (searchs.length == 3) {
      return this.search(searchs[0], searchs[1], searchs[2],limit);
    } else {
      return this.search("", "", "",limit);
    }
  }

  @Override
  public List<Location> search(String area, String city, String place,Integer limit) {
    return this.locationDao.search(area, city, place,limit);
  }

}
