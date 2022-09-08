package com.webkorps.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UpdateUserProfileService;
import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.User;
import com.webkorps.model.UserProfile;
@Service
public class UpdateUserProfileImp implements UpdateUserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserProfile updateUserProfile1(Integer id) {
		
		UserProfile findByUserUserId = this.userProfileRepository.findByUserUserId(id);
		return findByUserUserId;
	}
	@Override
	public UserProfile updateUserProfile(Integer id, UserProfile userProfile, MultipartFile file) throws IOException {
		   String profilePhoto = "";
					if (!file.isEmpty()) {
						
						System.out.println("helldkfddkkdfddfdfd--->");
						profilePhoto = file.getOriginalFilename().trim();
						
						System.out.println("profilePhoto-->"+profilePhoto);
						
						InputStream inputStream =file.getInputStream();
						
						String path = "D:\\Spring-Boot-Projects\\Friend-Book-Project\\src\\main\\webapp\\view\\userProfileImg\\"+profilePhoto;
						int bytes = 0;
						FileOutputStream fs = new FileOutputStream(path);
						while ((bytes = inputStream.read()) != -1)
							fs.write(bytes);
						fs.close();
						userProfile.setUserImage(profilePhoto);
						
						
					}
					
				  UserProfile findByUserProfileId = this.userProfileRepository.findByUserProfileId(id);
					
					findByUserProfileId.setFavoriteBooks(userProfile.getFavoriteBooks());
					
					findByUserProfileId.setFavoriteSongs(userProfile.getFavoriteSongs());
					findByUserProfileId.setFavoritePlaces(userProfile.getFavoritePlaces());
					findByUserProfileId.setUserImage(userProfile.getUserImage());
						
					 // userProfile.setUser(findByUserProfileId); 
					  userProfileRepository.save(findByUserProfileId);
					 
					 
					  
					
				  
				   
						
			

		return null;
	}
	

}
