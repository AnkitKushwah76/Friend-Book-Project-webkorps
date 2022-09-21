package com.webkorps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.webkorps.Repository.UserPostRepository;
import com.webkorps.serviceImpl.UserPostServiceImp;

@Controller
public class DeletePostController {
	
	@Autowired
	private UserPostRepository userPostRepository;
	
	

	@PostMapping("/deletePost")
	public RedirectView addComments(@RequestParam("postId") int postId,HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		HttpSession session=request.getSession();
		this.userPostRepository.deleteById(Integer.parseInt(request.getParameter("postId")));
		redirectView.setUrl("showUserProfile");
		return redirectView;


}
}
