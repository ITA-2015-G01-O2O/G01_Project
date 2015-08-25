package com.group.tto.main.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.UserProfile;
import com.group.tto.main.dao.UserProfileDao;
import com.group.tto.main.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	private UserProfileDao userProfileDao;

	@Override
	@Transactional
	public void chargeUserProfileFundByProfileId(Long profileId,
			BigDecimal addFund) {
		
		UserProfile u = userProfileDao.findUserProfileByProfileId(profileId);
		
		u.setFund(u.getFund().add(addFund));

	}

	@Override
	@Transactional
	public List<Collect> getUserCollectVendorByProfileId(Long profileId) {
		return userProfileDao.findUserProfileByProfileId(profileId).getCollects();
		
	}
	
	

}
