package com.webkorps.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webkorbs.service.UserService;
//import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.User;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	// set UserSignup ServiceImp
	@Override
	public User userSignup(User user) {

		String fullName = user.getFullName();
		String use = generatUsername(fullName);
		user.setUserName(use);
		User usr = this.userRepository.save(user);
		return usr;
	}

	public String generatUsername(String fullName) {
		Random random = new Random();
		int index = fullName.indexOf(' ');
		String num = 100 + random.nextInt(899) + "";
		String userName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1, index) + num;
		System.out.println("userName-->" + userName);
		return userName;
	}

	// set UserLogin ServiceImp
	@Override
	public String userLogin(User user, HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user1 = this.userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		System.out.println("user1--44454-->" + user1);
		boolean flag = false;

		if (user1 != null && user1.isStatus() == true) {
			session.setAttribute("userId", user1.getId());
			session.setAttribute("userName", user1.getUserName());

			session.setAttribute("userEmail", user1.getUserEmail());
			System.out.println("yes");
			user.setStatus(false);

			return "first";

		}
		if (user1 == null) {
			return "second";
		}
		return null;

	}

	// set UserProfile ServiceImp
	@Override
	public void setUserProfile(User user, String userName, MultipartFile imageFile)
			throws FileNotFoundException, IOException {
		String profilePhoto = "";
		if (!imageFile.isEmpty()) {

			System.out.println("helldkfddkkdfddfdfd--->");
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
}
