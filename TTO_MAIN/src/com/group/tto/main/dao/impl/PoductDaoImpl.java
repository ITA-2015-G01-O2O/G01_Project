package com.group.tto.main.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Product;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.PoductDao;


@Repository
public class PoductDaoImpl extends BaseDao<Product> implements PoductDao {

}
