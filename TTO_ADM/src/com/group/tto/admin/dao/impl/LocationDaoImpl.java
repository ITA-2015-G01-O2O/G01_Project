package com.group.tto.admin.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.admin.dao.BaseDao;
import com.group.tto.admin.dao.LocationDao;
import com.group.tto.cmn.model.Location;

@Repository
public class LocationDaoImpl extends BaseDao<Location> implements LocationDao {

  private static final String FIELD_AREA = "area";
  private static final String FIELD_CITY = "city";
  private static final String FIELD_PLACE = "place";

  @Override
  public List<Location> search(String area,String city,String place) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Location> query = builder.createQuery(Location.class);
    Root<Location> location = query.from(Location.class);

    Predicate predicate =
        builder.and(builder.like(location.get(FIELD_AREA).as(String.class), "%" + area + "%"),
            builder.and(builder.like(location.get(FIELD_CITY).as(String.class), "%" + city + "%"),
                builder.like(location.get(FIELD_PLACE).as(String.class), "%" + place + "%")));
    List<Location> result =
        this.getEntityManager().createQuery(query.where(predicate)).getResultList();

    return result;
  }
}
