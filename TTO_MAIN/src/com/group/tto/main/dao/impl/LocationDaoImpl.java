package com.group.tto.main.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Location;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.LocationDao;


@Repository
public class LocationDaoImpl extends BaseDao<Location> implements LocationDao {

  private static final String FIELD_AREA = "area";
  private static final String FIELD_CITY = "city";
  private static final String FIELD_PLACE = "place";

  @Override
  public List<Location> getAllLocations() {
    List<Location> locations = new ArrayList<Location>();
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Location> query = builder.createQuery(Location.class);
    Root<Location> root = query.from(Location.class);

    locations = this.getEntityManager().createQuery(query).getResultList();

    return locations;
  }


  @Override
  public List<Location> search(String area, String city, String place,Integer limit) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Location> query = builder.createQuery(Location.class);
    Root<Location> location = query.from(Location.class);

    Predicate predicate =
        builder.and(builder.like(location.get(FIELD_AREA).as(String.class), "%" + area + "%"),
            builder.and(builder.like(location.get(FIELD_CITY).as(String.class), "%" + city + "%"),
                builder.like(location.get(FIELD_PLACE).as(String.class), "%" + place + "%")));
    List<Location> result;
    if(limit!=null){
      result =
          this.getEntityManager().createQuery(query.where(predicate)).setMaxResults(limit).getResultList();
    }else{
      result =
          this.getEntityManager().createQuery(query.where(predicate)).getResultList();
    }

    return result;
  }


  @Override
  public List<Location> search(String search,Integer limit) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Location> query = builder.createQuery(Location.class);
    Root<Location> location = query.from(Location.class);

    Predicate predicate =
        builder.or(builder.like(location.get(FIELD_AREA).as(String.class), "%" + search + "%"),
            builder.or(builder.like(location.get(FIELD_CITY).as(String.class), "%" + search + "%"),
                builder.like(location.get(FIELD_PLACE).as(String.class), "%" + search + "%")));
    List<Location> result;
    if(limit!=null){
      result =
          this.getEntityManager().createQuery(query.where(predicate)).setMaxResults(limit).getResultList();
    }else{
      result =
          this.getEntityManager().createQuery(query.where(predicate)).getResultList();
    }
    

    return result;
  }


}
