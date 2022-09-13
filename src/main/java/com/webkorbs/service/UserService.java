package com.webkorbs.service;

import java.io.FileNotFoundException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.webkorbs.dto.UserProfileDto;
import com.webkorps.model.User;


public interface UserService {
	
	public User userSignup(User user);
	
   public  String  userLogin(User user,HttpServletRequest request);
	
		
   public void setUserProfile(User user,String userName, MultipartFile imageFile) throws FileNotFoundException, IOException;

 //for user profile
 	public UserProfileDto getProfile(int userId);
 		

	
	

}
