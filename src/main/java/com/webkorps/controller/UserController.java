package com.webkorps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.model.UserProfile;

@Controller
public class UserController {

	@Autowired private UserProfileRepository userProfileRepository;
	
	@RequestMapping("/userDashboard")
	public String UserDashboard()
	{
		return  "User/userDashboard";
	}
	
	@RequestMapping("/showUserProfile")
	public ModelAndView showUserProfile(HttpSession session ) {
		
		ModelAndView modelAndView=new ModelAndView();
		UserProfile userProfile=new UserProfile();
		Integer  id = (Integer)session.getAttribute("userId");
		 UserProfile findByUserUserId = this.userProfileRepository.findByUserUserId(id);
		 String favoriteBooks = findByUserUserId.getFavoriteBooks();
		 String favoritePlaces = findByUserUserId.getFavoritePlaces();
		 String favoriteSongs = findByUserUserId.getFavoriteSongs();
		 String userImage = findByUserUserId.getUserImage();
		   modelAndView.addObject("favoriteBooks", favoriteBooks);
		   modelAndView.addObject("favoritePlaces", favoritePlaces);
		   modelAndView.addObject("favoriteSongs", favoriteSongs);
		   modelAndView.addObject("userImage", userImage);
		modelAndView.setViewName("/User/ShowUserProfile");
		return modelAndView ;
	}
	
	
	
	
	
	
	
	
}
