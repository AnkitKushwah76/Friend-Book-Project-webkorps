package com.webkorps.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UserService;
import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.User;
import com.webkorps.model.UserProfile;

@Controller
public class HomeController {

	 @Autowired 
		private UserService userService;
	 
	 @Autowired 
	   private UserRepository userRepository;
	 @Autowired
	 private UserProfileRepository userProfileRepository;
	 
	 @RequestMapping("/")
	  public String home()
	  {
	
	  return "home"; 
	  }
	 	
		 @RequestMapping("/signup")
		  public String signup() { 
		  return "signup"; 
		  }
		 
		 
		//handler  for registerUser
		@PostMapping("/register")
		public ModelAndView registerUser(@ModelAttribute   User user,HttpSession session) {	
			  
			ModelAndView  modelAndView=new ModelAndView();
			
			User usr = this.userService.userSignup(user);
			  
			       session.setAttribute("sucessfull", "Registration Sucessfully !!");
			       modelAndView.setViewName("login");
			       
				return modelAndView;
		}
	
	 
		/* Login Page Start */ 
		
		 @RequestMapping("/signin")
		  public String signin() { 
		  return "login"; 
		  }
	  
	   // handler for  custom login 
	
		@PostMapping("/login")
		public String loginPage(@ModelAttribute User user,Model model,HttpSession session)
		{
		                String userLogin = userService.userLogin(user,model,session);
		                
		                
		                if(userLogin=="signup")
		                {
		                	return "User/userDashboard";
		                }
		                if(userLogin=="UserProfile")
		                {
		                	return "/User/setUserProfile";
		                }
		                else {
						return userLogin;
		                }
					}
		
		/* Login Page End */
		
		@RequestMapping("/logout")
		  public String logout(HttpSession session) { 
			
			session.setAttribute("logout", "logout Sucessfully !!");
		  return "login"; 
		  }
		
		
			// Start Search user 
		
		//handler for search
		@GetMapping("/searchdata")	
		public ModelAndView searchdata(@RequestParam("search") String search) {
			System.out.println("Search -> "+search);
			 User userByUserName = this.userRepository.UserByUserName(search);
			 int userId = userByUserName.getUserId();
			   UserProfile findByUserUserId = userProfileRepository.findByUserUserId(userId);
			   String userImage = findByUserUserId.getUserImage();
		 ModelAndView modelAndView=new ModelAndView();
		 modelAndView.addObject("userdata", userByUserName);
			 modelAndView.addObject("userImage", findByUserUserId);
			
			 modelAndView.setViewName("User/searchUser");
			return modelAndView;
		}
		
		@ResponseBody
		@GetMapping("/search")
		public List<User> getAllUser (@RequestParam("name") String search)
		{
			List<User> findByUserNameContains = this.userRepository.findByUserNameContains(search);
			
			System.out.println(findByUserNameContains);
			
			return findByUserNameContains;
		}
		
		//  End Search user 
}
