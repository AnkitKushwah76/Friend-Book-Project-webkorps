package com.webkorps.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UserProfileService;
import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.User;
import com.webkorps.model.UserProfile;

@Service
public class UserProfileServiceImp  implements UserProfileService{

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private UserProfileRepository userProfileRepository;
	
	
	@Override
	public  void setUserProfile(UserProfile userProfile,String userEmail,MultipartFile imageFile,HttpSession session) throws IOException 
	{
				
		ModelAndView model=new ModelAndView();	   
		   String profilePhoto = "";
			if (!imageFile.isEmpty()) {
				
				System.out.println("helldkfddkkdfddfdfd--->");
				profilePhoto = imageFile.getOriginalFilename().trim();
				
				System.out.println("profilePhoto-->"+profilePhoto);
				
				InputStream inputStream = imageFile.getInputStream();
				
				String path = "D:\\Spring-Boot-Projects\\Friend-Book-Project\\src\\main\\webapp\\view\\userProfileImg\\"+profilePhoto;
				int bytes = 0;
				FileOutputStream fs = new FileOutputStream(path);
				while ((bytes = inputStream.read()) != -1)
					fs.write(bytes);
				fs.close();
				userProfile.setUserImage(profilePhoto);
				
				
			}
			
			User userByUserName = this.userRepository.getUserByUserName(userEmail);
			  userProfile.setUser(userByUserName); 
			  userProfileRepository.save(userProfile);
			  model.addObject("setProfile", "Profile Add SucessFully !!");
			
		  
		   
				
	}

}
