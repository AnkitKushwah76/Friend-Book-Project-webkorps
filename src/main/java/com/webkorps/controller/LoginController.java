package com.webkorps.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webkorbs.service.UserService;
import com.webkorps.model.User;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	/* Login Page Start */

	@RequestMapping("/signin")
	public String signin() {
		return "login";
	}

	// handler for custom login
	@PostMapping("/login")
	public String loginPage(@ModelAttribute User user, Model model, HttpServletRequest request) {

		if (userService.userLogin(user, request).equals("first")) {
			model.addAttribute("sucessfully", "Login SucessFully !! ");
			return "setUserProfile";
		} else if (userService.userLogin(user, request).equals("second")) {
			return "userDashboard";
		} else {
			model.addAttribute("error", "Invalid username and Password");
			return "login";
		}

	}

	// logout api...
	@RequestMapping("/logout")
	public String logout(Model model) {

		model.addAttribute("logout", "logout Sucessfully !!");
		return "login";
	}

	/* Login Page End */

}
