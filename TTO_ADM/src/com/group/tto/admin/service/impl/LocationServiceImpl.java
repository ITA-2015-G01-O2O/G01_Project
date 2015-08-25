package com.group.tto.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.dao.LocationDao;
import com.group.tto.admin.service.LocationService;
import com.group.tto.cmn.model.Location;

@Service
public class LocationServiceImpl implements LocationService {
  @Autowired
  private LocationDao dao;

  @Override
  @Transactional
  public List<Location> search(String search, String splitor) {
    String[] searchs = search.split(splitor);
    if (searchs.length == 1) {
      return this.search(searchs[0], "", "");
    } else if (searchs.length == 2) {
      return this.search(searchs[0], searchs[1], "");
    } else if (searchs.length == 3) {
      return this.search(searchs[0], searchs[1], searchs[2]);
    } else {
      return this.search("", "", "");
    }
  }

  @Override
  public List<Location> search(String area, String city, String place) {
    return this.dao.search(area, city, place);
  }


}
