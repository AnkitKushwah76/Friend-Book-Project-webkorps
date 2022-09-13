package com.webkorps.serviceImpl;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.webkorbs.dto.UserProfileDto;
import com.webkorbs.service.UserPostService;
import com.webkorbs.service.UserService;
//import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.Following;
import com.webkorps.model.User;
import com.webkorps.model.UserPost;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserFollowerServiceImp userFollowerServiceImp;

	@Autowired
	private FollowingServiceImpl followingServiceImpl;

	@Autowired
	private UserPostService userPostService;
	
	@Autowired
	private UserPostServiceImp userPostServiceImp;

	// set UserSignup ServiceImp
	@Override
	public User userSignup(User user) {

		String fullName = user.getFullName();
		String use = generatUsername(fullName);
		user.setUserName(use);
		User usr = this.userRepository.save(user);
		return usr;
	}

	// this method use for generatUsername...
	public String generatUsername(String fullName) {
		Random random = new Random();

		int num = 100 + random.nextInt(899);
		String userName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1) + num;
		System.out.println("userName-->" + userName);
		return userName;
	}

	// set UserLogin ServiceImp
	
	@Transactional
	public String userLogin(User user, HttpServletRequest request) {
          
		
		HttpSession session = request.getSession();
		System.out.println("user0000"+user);
		User user1 = this.userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		System.out.println("user1--44454-->" + user1);
		
		  
		 
		if(user1 !=null)
		{	
			session.setAttribute("userId", user1.getId());
			  session.setAttribute("userName", user1.getUserName());
			  session.setAttribute("userEmail", user1.getUserEmail());
			  
			System.out.println();
			if (user1.isStatus() == true) {
				int i = (int) session.getAttribute("userId");
				System.out.println("i-->" + i);
				 this.userRepository.updateById((int) session.getAttribute("userId"));
				return "first";
			} else {
	
				return "second";
			}
		}
		else 
		{
			
			return "error";
		}

	}

	// set UserProfile ServiceImp
	@Override
	public void setUserProfile(User user, String userName, MultipartFile imageFile)
			throws FileNotFoundException, IOException {
		String profilePhoto = "";
		if (!imageFile.isEmpty()) {
			profilePhoto = imageFile.getOriginalFilename().trim();

			System.out.println("profilePhoto-->" + profilePhoto);
			InputStream inputStream = imageFile.getInputStream();
			String path = "D:\\Spring-Boot-Projects\\Friend-Book-Project\\src\\main\\webapp\\view\\userProfileImg\\"
					+ profilePhoto;
			int bytes = 0;
			FileOutputStream fs = new FileOutputStream(path);
			while ((bytes = inputStream.read()) != -1)
				fs.write(bytes);
			fs.close();
			user.setUserImage(profilePhoto);
		}
		User userByUserName = this.userRepository.findByUserEmail(userName);
		userByUserName.setFavoriteBooks(user.getFavoriteBooks());
		userByUserName.setFavoritePlaces(user.getFavoritePlaces());
		userByUserName.setFavoriteSongs(user.getFavoriteSongs());
		userByUserName.setUserImage(profilePhoto);
		System.out.println("userByUserName-->" + userByUserName);
		userRepository.save(userByUserName);

	}

	// this method get userProfile..dto
	@Override
	public UserProfileDto getProfile(int userId) {
		UserProfileDto userProfileDto = new UserProfileDto();

		// get all post particular user..
		List<UserPost> post = this.userPostService.getPost(userId);
		System.out.println("List--->" + post);

		// count user followers
		userProfileDto.setGetAllPost(post);
		userProfileDto.setCountFollowers(this.userFollowerServiceImp.countFollower(userId));
		// count user following
		userProfileDto.setCountFollowing(this.followingServiceImpl.countFollowing(userId));
		// count user post
		userProfileDto.setCountPost(this.userPostService.countPost(userId));
		List<UserPost> getAllPost = userProfileDto.getGetAllPost();
		System.out.println("getAllPost-->" + getAllPost);
		
		// get all following in particular...User..
		List<Following> allFollwing = followingServiceImpl.getAllFollwing(userId);
//		    for(int i=0;i<allFollwing.size();i++)
//		    {
//		    	  allFollwing.get(i).getFollowing().getFullName();
//		    	  System.out.println(" allFollwing.get(i).getFollowing().getFullName()-->;"+ allFollwing.get(i).getFollowing().getFullName());
//		    }
		    userProfileDto.setUserFollowing(allFollwing);
		    
		System.out.println("allFollwing--->"+allFollwing);

		
		
		return userProfileDto;
	}
}
