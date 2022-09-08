package com.webkorps.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webkorbs.service.UserProfileService;
import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.model.UserProfile;

@Controller
@MultipartConfig
public class UserProfileController {
	
	@Autowired 
	private UserProfileService userProfileService;
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@RequestMapping("/userPro")
	public String userProfile()
	{
		
		return  "User/UserProfile";
	}
	
	@PostMapping("/userProfileSet")
	public String userProfileSet(@ModelAttribute UserProfile userProfile,@RequestParam("userImage1") MultipartFile file ,HttpSession session) throws IOException 
	{
		 String userEmail  =(String) session.getAttribute("userEmail");
	    this.userProfileService.setUserProfile(userProfile,userEmail,file);	
	   
		return  "User/userDashboard";
	}

}
