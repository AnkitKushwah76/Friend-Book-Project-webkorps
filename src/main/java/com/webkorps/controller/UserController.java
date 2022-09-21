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

import com.webkorbs.service.UserService;
import com.webkorps.Repository.NotificationsRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.Notifications;
import com.webkorps.model.User;
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
	private NotificationsRepository notificationsRepository;

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
		this.userService.setUserProfile(user, (String) session.getAttribute("userEmail"), file);

		return "userDashboard";
	}

	// show UserProfile Api.....

	@SuppressWarnings("unchecked")
	@RequestMapping("/showUserProfile")
	public ModelAndView showUserProfile(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("5455555454545");
		HttpSession session = request.getSession();
		Optional<User> findById = this.userRepository.findById((Integer) session.getAttribute("userId"));
		modelAndView.addObject("findByUser", findById.get());
		modelAndView.addObject("userprofileDto", this.userServiceImp.getProfile((int) session.getAttribute("userId")));
		modelAndView.setViewName("ShowUserProfile");
		return modelAndView;
	}

	// Update UserProfile Api.....
	@RequestMapping("/updateUserProfile")
	public ModelAndView ShowUpdateUserProfileForm(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("findByid", this.userRepository.findByid((Integer) session.getAttribute("userId")));
		modelAndView.setViewName("updateUserProfile");
		return modelAndView;

	}

	// search user api....
	@GetMapping("/searchdata")
	public ModelAndView searchdata(@RequestParam("search") String search,@RequestParam("userId")int id,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
	   modelAndView.addObject("alreadfollow", this.notificationsRepository.findByUserIdAndAccepted((int)session.getAttribute("userId"),id));
	   modelAndView.addObject("searchUserId", this.userRepository.UserByUserName(search));
		modelAndView.setViewName("searchUser");
		return modelAndView;
	}

	@ResponseBody
	@GetMapping("/search")
	public List<User> getAllUser(@RequestParam("name") String search) {
		return this.userRepository.findByUserNameContains(search);
	}

	// End Search user

}
