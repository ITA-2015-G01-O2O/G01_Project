package com.group.tto.main.vendor.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.vendor.dao.LocationDao;

@Repository("vendorLocationDaoImpl")
public class LocationDaoImpl extends BaseDao<Location> implements LocationDao {
  public Location selectLocation(int sid) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Store> query = builder.createQuery(Store.class);
    Root<Store> store = query.from(Store.class);

    Predicate condition = builder.equal(store.get("storeId"), sid);
    Store store1 = this.getEntityManager().createQuery(query.where(condition)).getSingleResult();
    Location location = store1.getLocation();

    return location;

  }

  @Override
  public int getLocation(String city, String area, String place) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Location> query = builder.createQuery(Location.class);
    Root<Location> location = query.from(Location.class);

    Predicate condition =
        builder.and(builder.equal(location.get("area"), area),
            builder.equal(location.get("city"), city), builder.equal(location.get("place"), place));

    Location location1 =
        this.getEntityManager().createQuery(query.where(condition)).getSingleResult();
    long id = location1.getLocationId();
    return (int) id;
  }
}
