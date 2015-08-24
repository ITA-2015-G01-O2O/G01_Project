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
  public List<Location> search(String search) {
    return this.dao.search(search);
  }


}
