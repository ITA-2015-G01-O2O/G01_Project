package com.group.tto.main.dao;

import com.group.tto.cmn.model.UserProfile;

public interface UserProfileDao {
	
	
	public UserProfile findUserProfileByProfileId(Long profileId);

}
