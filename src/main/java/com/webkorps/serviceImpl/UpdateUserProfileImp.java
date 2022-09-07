package com.webkorps.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UpdateUserProfileService;
import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.model.User;
import com.webkorps.model.UserProfile;
@Service
public class UpdateUserProfileImp implements UpdateUserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;
	@Override
	public UserProfile updateUserProfile(Integer id) {
		
		UserProfile findByUserUserId = this.userProfileRepository.findByUserUserId(id);
		return findByUserUserId;
	}

}
