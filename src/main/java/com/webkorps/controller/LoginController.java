package com.webkorps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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

		@PostMapping("/login")
	public RedirectView loginPage(@ModelAttribute User user, Model model, HttpServletRequest request) {

		RedirectView redirectView=new RedirectView();
		HttpSession session=request.getSession();
		if (userService.userLogin(user, request).equals("first")) {
			model.addAttribute("sucessfully", "Login SucessFully !! ");
			redirectView.setUrl("setUserProfile");
		} else if (userService.userLogin(user, request).equals("second")) {
			redirectView.setUrl("showUserProfile");
			return redirectView;
		} else {
			session.setAttribute("error","Invalid username and Password" );
			redirectView.setUrl("signin");
			return redirectView;
		}
		return redirectView;

	}

	// logout api...
	@RequestMapping("/logout")
	public String logout(Model model) {

		model.addAttribute("logout", "logout Sucessfully !!");
		return "login";
	}

	/* Login Page End */

}
