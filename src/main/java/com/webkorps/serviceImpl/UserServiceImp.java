package com.webkorps.serviceImpl;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.webkorbs.dto.UserProfileDto;
import com.webkorbs.service.UserPostService;
import com.webkorbs.service.UserService;
import com.webkorps.Repository.UserFollowerRepository;
//import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.Following;
import com.webkorps.model.User;
import com.webkorps.model.UserFollowers;
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

	// set UserSignup ServiceImp
	@Override
	public User userSignup(User user) {

		String fullName = user.getFullName();
		String use = generatUsername(fullName);
		user.setUserName(use);
		user.setUserImage("No_image.png");
		user.setFavoriteBooks("Not Found");
		user.setFavoritePlaces("Not Found");
		user.setFavoriteSongs("Not Found");

		return this.userRepository.save(user);
	}

	// this method use for generatUsername...
	public String generatUsername(String fullName) {
		Random random = new Random();
		int num = 100 + random.nextInt(899);
		return fullName.substring(0, 1).toUpperCase() + fullName.substring(1) + num;
	}

	// set UserLogin ServiceImp

	@Transactional
	public String userLogin(User user, HttpServletRequest request) {

		HttpSession session = request.getSession();
		System.out.println("user0000" + user);
		User user1 = this.userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		System.out.println("user1--44454-->" + user1);

		if (user1 != null) {
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
		} else {

			return "error";
		}

	}

	// set UserProfile ServiceImp
	@Override
	public void setUserProfile(User user, String userName, MultipartFile imageFile)
			throws FileNotFoundException, IOException {
		String profilePhoto = "";
		if (imageFile.isEmpty()) {
			user.setUserImage("No_image.png");
		}
		if (user.getFavoriteBooks().isEmpty()) {
			user.setFavoriteBooks("Not Found");

		}
		if (user.getFavoritePlaces().isEmpty()) {
			user.setFavoritePlaces("Not Found");

		}
		if (user.getFavoriteSongs().isEmpty()) {
			user.setFavoriteSongs("Not Found");
		}
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
			User userByUserName = this.userRepository.findByUserEmail(userName);
			userByUserName.setUserImage(profilePhoto);

		}
		User userByUserName = this.userRepository.findByUserEmail(userName);
		userByUserName.setFavoriteBooks(user.getFavoriteBooks());
		userByUserName.setFavoritePlaces(user.getFavoritePlaces());
		userByUserName.setFavoriteSongs(user.getFavoriteSongs());
//		userByUserName.setUserImage(profilePhoto);
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
		System.out.println("allFollwing--->" + allFollwing);
		userProfileDto.setUserFollowing(allFollwing);

		// get all followers in particular User...
		List<UserFollowers> allFollower = userFollowerServiceImp.getAllFollower(userId);
		System.out.println("allFollower 7649008047-->" + allFollower);

		// get all post in all followers....
		List<UserPost> followersPost = new ArrayList<UserPost>();
		for (int i = 0; i < allFollower.size(); i++) {

			followersPost.addAll(this.userPostService.getPost(allFollower.get(i).getFollower().getId()));
		}
		userProfileDto.setGetAllFollowerPost(followersPost);
		System.out.println("post1--->" + followersPost);
		userProfileDto.setUserFollowers(userFollowerServiceImp.getAllFollower(userId));
		return userProfileDto;
	}

}
