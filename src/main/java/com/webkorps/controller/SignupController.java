package com.webkorps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// handler for registerUser
	@PostMapping("/register")
	public ModelAndView registerUser(@ModelAttribute User user, HttpSession session,
			@RequestParam("captchanam") String captchanam) {
		ModelAndView modelAndView = new ModelAndView();
		String captcha = (String) session.getAttribute("captcha_security");
		System.out.println("captcha---" + captcha);
		if (captcha.equals(captchanam))
		{
			user.setStatus(true);
			User usr = this.userService.userSignup(user);
			modelAndView.addObject("sucessfull", "Registration Sucessfully !!");
			modelAndView.setViewName("login");

		}
		else {
			modelAndView.addObject("error", "Captcha Invalid !!");
			modelAndView.setViewName("signup");

		}
			
		return modelAndView;
	}

}
