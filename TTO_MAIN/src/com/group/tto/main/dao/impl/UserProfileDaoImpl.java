package com.group.tto.main.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.UserProfileDao;

@Repository
public class UserProfileDaoImpl extends BaseDao<UserProfile> implements UserProfileDao {
	
	
	private static final String FIELD_PROFILEID = "userProfileId";

	@Override
	public UserProfile findUserProfileByProfileId(Long profileId) {
		CriteriaBuilder critBuilder = this.getEntityManager().getCriteriaBuilder();
	    CriteriaQuery<UserProfile> critQuery = critBuilder.createQuery(UserProfile.class);
	    Root<UserProfile> userProfile = critQuery.from(UserProfile.class);

	    Predicate condition =critBuilder.equal(userProfile.get(FIELD_PROFILEID),profileId);
	    return this.getEntityManager().createQuery(critQuery.where(condition)).getResultList().get(0);
	
	}

}
