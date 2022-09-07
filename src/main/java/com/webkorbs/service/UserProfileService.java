package com.webkorbs.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.webkorps.model.UserProfile;

public interface UserProfileService {

	public void setUserProfile(UserProfile userProfile,String userEmail,MultipartFile imageFile,HttpSession session) throws FileNotFoundException, IOException;

	
}
