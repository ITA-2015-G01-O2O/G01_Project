package com.group.tto.admin.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.admin.cmn.ShopSearchCriteria;
import com.group.tto.admin.cmn.StringUtils;
import com.group.tto.admin.dao.BaseDao;
import com.group.tto.admin.dao.StoreDao;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.cmn.model.Admin;
import com.group.tto.cmn.model.Store;

@Repository
public class StoreDaoImpl extends BaseDao<Store> implements StoreDao {
  public StoreDaoImpl() {
    super(Store.class);
  }

  private static final String FIELD_STORE_ID = "storeId";
  private static final String FIELD_STORE_NAME = "storeName";
  private static final String FIELD_STORE_PROFILE = "storeProfile";
  private static final String FIELD_STORE_PROFILE_STATUS = "status";
  private static final String FIELD_STORE_IS_HOT = "isHot";
  private static final String FIELD_STORE_LOCATION = "location";
  private static final String FIELD_STORE_LOCATION_ID = "locationId";



  @Override
  public PageDTO<Store> search(ShopSearchCriteria searchCriteria) {
    PageDTO<Store> pageDTO = new PageDTO<Store>();

    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Store> query = builder.createQuery(Store.class);
    Root<Store> store = query.from(Store.class);

    Predicate predicate = buildSearchPredicate(builder, searchCriteria, store);

    List<Store> result =
        this.getEntityManager().createQuery(query.where(predicate))
            .setFirstResult(searchCriteria.getStart().intValue())
            .setMaxResults(searchCriteria.getLimit().intValue()).getResultList();

    pageDTO.setLimit(searchCriteria.getLimit());
    pageDTO.setStart(searchCriteria.getStart());
    pageDTO.setTotal(this.getTotal(searchCriteria));
    pageDTO.setDatas(result);

    return pageDTO;
  }

  private Long getTotal(ShopSearchCriteria searchCriteria) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Long> query = builder.createQuery(Long.class);
    Root<Store> store = query.from(Store.class);

    Predicate predicate = buildSearchPredicate(builder, searchCriteria, store);

    return this.getEntityManager()
        .createQuery(query.select(builder.countDistinct(store)).where(predicate)).getSingleResult();
  }

  private Predicate buildSearchPredicate(CriteriaBuilder builder,
      ShopSearchCriteria searchCriteria, Root<Store> store) {
    Predicate predicate = builder.isNotNull(store.get(FIELD_STORE_ID));
    if (!StringUtils.isNullOrEmpty(searchCriteria.getStopName())) {
      predicate =
          builder.and(
              predicate,
              builder.like(store.get(FIELD_STORE_NAME).as(String.class),
                  "%" + searchCriteria.getStopName() + "%"));
    }
    if (!StringUtils.isNullOrEmpty(searchCriteria.getStatus())) {
      predicate =
          builder.and(predicate, builder.like(
              store.get(FIELD_STORE_PROFILE).get(FIELD_STORE_PROFILE_STATUS).as(String.class), "%"
                  + searchCriteria.getStatus() + "%"));
    }
    if (searchCriteria.getLocationId() != null) {
      predicate =
          builder.and(
              predicate,
              builder.equal(
                  store.get(FIELD_STORE_LOCATION).get(FIELD_STORE_LOCATION_ID).as(Long.class), "%"
                      + searchCriteria.getLocationId() + "%"));
    }
    predicate =
        builder.and(
            predicate,
            builder.equal(store.get(FIELD_STORE_IS_HOT).as(Boolean.class),
                searchCriteria.getIsHot()));

    return predicate;
  }

  @Override
  public Store getById(Long id) {
    return this.getEntityManager().find(Store.class, id);
  }

  @Override
  public void save(Store store) {
    this.update(store);
  }

  @Override
  public Long getTotalOf(String status) {
    CriteriaBuilder critBuilder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Long> critQuery = critBuilder.createQuery(Long.class);
    Root<Store> root = critQuery.from(Store.class);

    Predicate predicate =
        critBuilder.equal(root.get(FIELD_STORE_PROFILE).get(FIELD_STORE_PROFILE_STATUS), status);

    return this.getEntityManager()
        .createQuery(critQuery.select(critBuilder.countDistinct(root)).where(predicate))
        .getSingleResult();

  }

}
