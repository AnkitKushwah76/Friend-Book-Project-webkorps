package com.webkorps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UserService;
import com.webkorps.model.User;

@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/signup")
	public String signup() { 
		return "signup"; 
	}
	
	
	//handler  for registerUser
		@PostMapping("/register")
		public ModelAndView registerUser(@ModelAttribute User user) {				
			ModelAndView  modelAndView=new ModelAndView();
			user.setStatus(true);
			User usr = this.userService.userSignup(user);
			  modelAndView.addObject("sucessfull", "Registration Sucessfully !!");	
			modelAndView.setViewName("signup");

			return modelAndView;
		}

}
