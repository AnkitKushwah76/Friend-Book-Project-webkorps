package com.webkorps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.dto.UserProfileDto;
import com.webkorps.serviceImpl.PostLikeServiceImp;
import com.webkorps.serviceImpl.UserServiceImp;

@Controller
public class showAllFollowersPostController {

	@Autowired
	private UserServiceImp userServiceImp;

	@Autowired
	private PostLikeServiceImp postLikeServiceImp;

	@RequestMapping("showAllFollowersPost")
	public ModelAndView showAllFollowersPost(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		UserProfileDto userProfileDto = new UserProfileDto();
		userProfileDto = this.userServiceImp.getProfile((int) session.getAttribute("userId"));
		modelAndView.addObject("showAllFollowers", userProfileDto);
		modelAndView.setViewName("showAllFollowersPost");
		return modelAndView;
	}

	@ResponseBody
	@GetMapping("/postLike")
	public String postLike(@RequestParam("postId") int postId, HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (this.postLikeServiceImp.addPostLike(postId, (Integer) session.getAttribute("userId"))) {

			return "success";
		} else {
			return "no";
		}

	}
}
