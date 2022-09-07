package com.webkorbs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.webkorps.model.User;


public interface UserService {
	
	public User userSignup(User user);
	
	public String userLogin(User user,Model model,HttpSession session);
	
	

}
