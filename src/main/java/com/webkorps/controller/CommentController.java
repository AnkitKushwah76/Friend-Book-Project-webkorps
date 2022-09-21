package com.webkorps.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.webkorps.serviceImpl.PostCommentsServiceImp;

@Controller
public class CommentController {

	@Autowired
	public PostCommentsServiceImp postCommentsServiceImp;

	@PostMapping("/addComments")
	public RedirectView addComments(HttpServletRequest request) {
		HttpSession session = request.getSession();
		RedirectView redirectView = new RedirectView();
		
		this.postCommentsServiceImp.addComment((int) session.getAttribute("userId"),
				Integer.parseInt(request.getParameter("postId")), request.getParameter("comment"));
		redirectView.setUrl("showAllFollowersPost");
		return redirectView;

	}

	@GetMapping("/getComments")
	public ModelAndView getComments(HttpSession session, @RequestParam("postId") int id,@RequestParam("check") String check) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("getallComments", this.postCommentsServiceImp.getallComments(id));
			session.setAttribute("check", check);
		modelAndView.setViewName("ViewComments");
		return modelAndView;

	}

}
