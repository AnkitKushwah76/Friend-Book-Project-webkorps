package com.webkorps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.webkorps.model.Comments;
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
	public ModelAndView getComments(HttpServletRequest request, @RequestParam("postId") int id) {
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();

		List<Comments> getallComments = this.postCommentsServiceImp.getallComments(id);
		System.out.println("getallComments--->" + getallComments.size());

		modelAndView.addObject("getallComments", getallComments);
		modelAndView.setViewName("ViewComments");
		return modelAndView;

	}

}
