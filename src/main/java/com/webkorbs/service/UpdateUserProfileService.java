package com.webkorbs.service;

import org.springframework.web.servlet.ModelAndView;

import com.webkorps.model.UserProfile;

public interface UpdateUserProfileService {
	
	public UserProfile updateUserProfile(Integer id);

}
