package com.group.tto.main.service;

import java.math.BigDecimal;
import java.util.List;

import com.group.tto.cmn.model.Collect;

public interface UserProfileService {
	public void chargeUserProfileFundByProfileId(Long profileId,BigDecimal addFund);
	public List<Collect> getUserCollectVendorByProfileId(Long profileId);
}
