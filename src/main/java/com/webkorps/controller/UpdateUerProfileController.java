package com.webkorps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UpdateUserProfileService;
import com.webkorps.model.UserProfile;

@Controller
public class UpdateUerProfileController {
	
	@Autowired
	private UpdateUserProfileService updateUserProfileService;
	
	@RequestMapping("/updateUserProfile")
	public ModelAndView  ShowUpdateUserProfileForm(HttpSession session) {
		
		ModelAndView modelAndView=new ModelAndView();
		  Integer  userId =(Integer) session.getAttribute("userId");
		   UserProfile updateUserProfile = this.updateUserProfileService .updateUserProfile(userId);
		   String favoriteBooks1 = updateUserProfile.getFavoriteBooks();
		   String favoritePlaces = updateUserProfile.getFavoritePlaces();
		   String favoriteSongs = updateUserProfile.getFavoriteSongs();
		    modelAndView.addObject("favoriteBooks1",favoriteBooks1);
		    modelAndView.addObject("favoritePlaces",favoritePlaces);
		    modelAndView.addObject("favoriteSongs",favoriteSongs);
		modelAndView.setViewName("User/updateUserProfile");
		return modelAndView;
		
		
	}
	
	
	 
	  
	 

}

