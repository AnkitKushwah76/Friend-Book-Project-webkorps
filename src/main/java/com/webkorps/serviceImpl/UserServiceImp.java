package com.webkorps.serviceImpl;
import java.io.File;
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
import com.webkorps.Repository.UserRepository;
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
		User user1 = this.userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		if (user1 != null) {
			session.setAttribute("userId", user1.getId());
			session.setAttribute("userName", user1.getUserName());
			session.setAttribute("userEmail", user1.getUserEmail());

			if (user1.isStatus() == true) {
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
		String path = "D:\\Spring-Boot-Projects\\Friend-Book-Project-webkorps\\src\\main\\webapp\\view\\userProfileImg";

		try {
			if (imageFile.isEmpty()) {
				User userByUserName = this.userRepository.findByUserEmail(userName);
				userByUserName.setFavoriteBooks(user.getFavoriteBooks());
				userByUserName.setFavoritePlaces(user.getFavoritePlaces());
				userByUserName.setFavoriteSongs(user.getFavoriteSongs());
				userRepository.save(userByUserName);

			} else {

				InputStream imageStream = imageFile.getInputStream();
				byte data[] = new byte[imageStream.available()];
				imageStream.read(data);

				FileOutputStream fileOutputStream = new FileOutputStream(
						path + File.separator + imageFile.getOriginalFilename());
				fileOutputStream.write(data);
				fileOutputStream.flush();
				fileOutputStream.close();
				user.setUserImage(imageFile.getOriginalFilename());

				User userByUserName = this.userRepository.findByUserEmail(userName);
				userByUserName.setFavoriteBooks(user.getFavoriteBooks());
				userByUserName.setFavoritePlaces(user.getFavoritePlaces());
				userByUserName.setFavoriteSongs(user.getFavoriteSongs());
				userByUserName.setUserImage(user.getUserImage());
				userRepository.save(userByUserName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method get userProfile..dto
	@Override
	public UserProfileDto getProfile(int userId) {
		UserProfileDto userProfileDto = new UserProfileDto();

		// get all post particular user..
		List<UserPost> post = this.userPostService.getPost(userId);

		// count user followers
		userProfileDto.setGetAllPost(post);
		userProfileDto.setCountFollowers(this.userFollowerServiceImp.countFollower(userId));
		// count user following
		userProfileDto.setCountFollowing(this.followingServiceImpl.countFollowing(userId));
		// count user post
		userProfileDto.setCountPost(this.userPostService.countPost(userId));
		List<UserPost> getAllPost = userProfileDto.getGetAllPost();

		// get all following in particular...User..
		userProfileDto.setUserFollowing(followingServiceImpl.getAllFollwing(userId));

		// get all followers in particular User...
		List<UserFollowers> allFollower = userFollowerServiceImp.getAllFollower(userId);
		userProfileDto.setUserFollowers(userFollowerServiceImp.getAllFollower(userId));

		// get all post in all followers....
		List<UserPost> followersPost = new ArrayList<UserPost>();
		for (int i = 0; i < allFollower.size(); i++) {

			followersPost.addAll(this.userPostService.getPost(allFollower.get(i).getFollower().getId()));
		}
		userProfileDto.setGetAllFollowerPost(followersPost);

		return userProfileDto;
	}

}
