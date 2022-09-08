package com.webkorbs.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webkorps.model.UserProfile;

public interface UpdateUserProfileService {
	
	public UserProfile updateUserProfile1(Integer id);
	public UserProfile updateUserProfile(Integer id, UserProfile userProfile, MultipartFile file) throws IOException;

	

}
