package com.group.tto.main.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Location;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.LocationDao;


@Repository
public class LocationDaoImpl extends BaseDao<Location> implements LocationDao {

  @Override
  public List<Location> getAllLocations() {
    List<Location> locations = new ArrayList<Location>();
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Location> query = builder.createQuery(Location.class);
    Root<Location> root=query.from(Location.class);
    
    locations = this.getEntityManager().createQuery(query).getResultList();
    
    return locations;
  }

}
