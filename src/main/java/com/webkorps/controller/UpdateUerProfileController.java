package com.webkorps.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UpdateUserProfileService;
import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.model.UserProfile;

@Controller
public class UpdateUerProfileController {
	
	@Autowired
	private UpdateUserProfileService updateUserProfileService;
	

	@Autowired
	private UserProfileRepository userProfileRepository;

	
	@RequestMapping("/updateUserProfile")
	public ModelAndView  ShowUpdateUserProfileForm(HttpSession session) {
		
		ModelAndView modelAndView=new ModelAndView();
		  Integer  userId =(Integer) session.getAttribute("userId");
		   UserProfile updateUserProfile = this.updateUserProfileService .updateUserProfile1(userId);
		   System.out.println("updateUserProfile-->"+updateUserProfile);
		   int userProfileId = updateUserProfile.getUserProfileId();
		   System.out.println("userProfileId-->"+userProfileId);
		   
		   session.setAttribute("userProfileId", userProfileId);
		     
		   String favoriteBooks1 = updateUserProfile.getFavoriteBooks();
		   String favoritePlaces = updateUserProfile.getFavoritePlaces();
		   String favoriteSongs = updateUserProfile.getFavoriteSongs();
		    modelAndView.addObject("favoriteBooks1",favoriteBooks1);
		    modelAndView.addObject("favoritePlaces",favoritePlaces);
		    modelAndView.addObject("favoriteSongs",favoriteSongs);
		modelAndView.setViewName("User/updateUserProfile");
		return modelAndView;
		
		
	}
	
	
	@PostMapping("/UpdateUserProfile")
	public String updateUserProfile(@ModelAttribute UserProfile userProfile,@RequestParam("userImage1") MultipartFile file ,HttpSession session) throws IOException 
	{
		Integer userProfileId  =(Integer) session.getAttribute("userProfileId");
		
		    
	     
		    this.updateUserProfileService.updateUserProfile(userProfileId,userProfile,file);
	   
		return  "User/userDashboard";
	}
	  
	 

}

