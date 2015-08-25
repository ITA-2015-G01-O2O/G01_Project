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
}
