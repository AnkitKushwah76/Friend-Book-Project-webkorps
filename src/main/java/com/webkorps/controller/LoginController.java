package com.webkorps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.webkorbs.service.UserService;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.User;
import com.webkorps.serviceImpl.UserServiceImp;

@Controller
public class LoginController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserServiceImp userServiceImp;
	
	/* Login Page Start */ 

	@RequestMapping("/signin")
	public String signin() { 
		return "login"; 
	}

	// handler for  custom login 
	@PostMapping("/login")
	public String loginPage(@ModelAttribute User user,Model model,HttpServletRequest request)
	{
	      String userLogin = userService.userLogin(user,request);
	      
		if(userLogin.equals("first")) {
			model.addAttribute("sucessfully","Login SucessFully !! ");
			return "setUserProfile";
		}
		else if(userLogin.equals("second"))
				{
			return "userDashboard";
				}
		else {
			 model.addAttribute("error", "Invalid username and Password");
			 return "login";
		}
		
	
	}
	
	//logout api...
	@RequestMapping("/logout")
	public String logout(Model model) {

		 model.addAttribute("logout", "logout Sucessfully !!");
		return "login";
	}

	
	
	/* Login Page End */

}
