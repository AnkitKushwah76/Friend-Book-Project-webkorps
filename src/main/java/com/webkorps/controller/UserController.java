package com.webkorps.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.dto.UserProfileDto;
import com.webkorbs.service.UserPostService;
import com.webkorbs.service.UserService;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.User;
import com.webkorps.model.UserFollowers;
import com.webkorps.serviceImpl.UserPostServiceImp;
import com.webkorps.serviceImpl.UserServiceImp;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServiceImp userServiceImp;

	@Autowired
	private UserPostService userPostService;

	@Autowired
	private UserPostServiceImp userPostServiceImp;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/userDashboard")
	public String userDashboard() {
		return "userDashboard";
	}

	@RequestMapping("/userPro")
	public String userProfile() {

		return "User/UserProfile";
	}

	// User Profile Set ..Api
	@PostMapping("/userProfileSet")
	public String userProfileSet(@ModelAttribute User user, @RequestParam("userImage1") MultipartFile file,
			HttpSession session) throws FileNotFoundException, IOException {
		String userEmail = (String) session.getAttribute("userEmail");
		Integer uerid = (Integer) session.getAttribute("userId");

		this.userService.setUserProfile(user, userEmail, file);

		return "userDashboard";
	}

	// show UserProfile Api.....

	@SuppressWarnings("unchecked")
	@RequestMapping("/showUserProfile")
	public ModelAndView showUserProfile(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("userId");
		Optional<User> findById = this.userRepository.findById(id);
		User user = findById.get();
		UserProfileDto userprofileDto = this.userServiceImp.getProfile((int) session.getAttribute("userId"));
		System.out.println("profile--->anku" + userprofileDto);
		List<UserFollowers> userFollowers = userprofileDto.getUserFollowers();
		System.out.println("userFollowers--78787-" + userFollowers);

		modelAndView.addObject("userprofileDto", userprofileDto);
		modelAndView.addObject("findByUser", user);
		modelAndView.setViewName("ShowUserProfile");
		return modelAndView;
	}

	// Update UserProfile Api.....
	@RequestMapping("/updateUserProfile")
	public ModelAndView ShowUpdateUserProfileForm(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Integer userId = (Integer) session.getAttribute("userId");
		modelAndView.addObject("findByid", this.userRepository.findByid(userId));
		modelAndView.setViewName("updateUserProfile");
		return modelAndView;

	}

	// search user api....
	@GetMapping("/searchdata")
	public ModelAndView searchdata(@RequestParam("search") String search) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Search -> " + search);
		User searchUserId = this.userRepository.UserByUserName(search);
		System.out.println("searchUserId-->" + searchUserId);
		modelAndView.addObject("searchUserId", searchUserId);
		modelAndView.setViewName("searchUser");
		return modelAndView;
	}

	@ResponseBody
	@GetMapping("/search")
	public List<User> getAllUser(@RequestParam("name") String search) {
		List<User> findByUserNameContains = this.userRepository.findByUserNameContains(search);
		return findByUserNameContains;
	}

	// End Search user

}
