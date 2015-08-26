package com.group.tto.main.service;

import java.math.BigDecimal;
import java.util.List;

import com.group.tto.cmn.model.Collect;
import com.group.tto.cmn.model.UserProfile;

public interface UserProfileService {
	public UserProfile chargeUserProfileFundByProfileId(Long profileId,BigDecimal addFund);
	public List<Collect> getUserCollectVendorByProfileId(Long profileId);
	public UserProfile getUserProfilebyId(Long profileId);
}
