package com.webkorps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UserPostService;
import com.webkorps.model.UserPost;

@Controller
public class AddPostController {

	@Autowired
	private UserPostService userPostService;

	@GetMapping("/addpost")
	public ModelAndView addPost() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AddPost");
		return modelAndView;
	}

	// this api use for add post
	@PostMapping("/AddPost")
	public ModelAndView addpost(@ModelAttribute UserPost userPost, @RequestParam("userImage1") MultipartFile image,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		UserPost addPost = this.userPostService.addPost(userPost, image, (int) session.getAttribute("userId"));
		if (addPost != null) {
			modelAndView.addObject("sucessMsg", "Post Add SucessFully.. !!");
		}
		modelAndView.setViewName("AddPost");
		return modelAndView;
	}
	
	

}
