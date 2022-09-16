
package com.webkorps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.webkorps.model.Notifications;
import com.webkorps.serviceImpl.NotificationImpl;

@Controller
public class FollowersController {

	@Autowired
	private NotificationImpl notificationImpl;

	// follow request 
	@GetMapping("/followrequest")
	public ModelAndView SendRequest(@ModelAttribute("id") int userId, HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();

		System.out.println("userId  anki--->" + userId);
		HttpSession session = req.getSession();
		String status = this.notificationImpl.addRequest(userId, (int) session.getAttribute("userId"));
		if (status.equals("success"))
			session.setAttribute("succMsg", "Request Sent To The User...");
		modelAndView.setViewName("userDashboard");
		return modelAndView;
	}
	@GetMapping("/checkUserRequest")
	public ModelAndView checkRequest(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = req.getSession();

		// get all follow request
		List<Notifications> requests = this.notificationImpl.getRequest((int) session.getAttribute("userId"));
		System.out.println("requests--->" + requests);
		modelAndView.addObject("request", requests);
		session.setAttribute("succMsg", req.getAttribute("succMsg"));
		modelAndView.setViewName("Friendsrequests");
		return modelAndView;
	}

	// accept follow request
	@GetMapping("/acceptrequest")
	public RedirectView acceptRequest(@RequestParam("userId") int userId, HttpServletRequest req) {
		RedirectView rd = new RedirectView();
		HttpSession session = req.getSession();
		System.out.println("userId---ankitkushwag>" + userId);
		if (this.notificationImpl.accept((int) session.getAttribute("userId"), userId) > 0)
			session.setAttribute("succMsg", "request Accepted..");
		rd.setUrl("checkUserRequest");
		return rd;
	}
	

	// followback to the user
	
	@GetMapping("/followbackUser")
	public RedirectView followBack(@RequestParam("userId") int userId, HttpServletRequest req) {
		RedirectView redirecatView = new RedirectView();
		HttpSession session = req.getSession();
		System.out.println("anananana-->"+userId);
		System.out.println("sjdsjdsjddsd--->"+(int) session.getAttribute("userId"));
		
		//boolean followBack = this.notificationImpl.followBack((int) session.getAttribute("userId"),userId);
		//System.out.println("followBack-->"+followBack);
		
		if(!this.notificationImpl.followBack((int) session.getAttribute("userId"),userId))
			//session.setAttribute("followback","followback...");
		redirecatView.setUrl("checkUserRequest");
		
		return redirecatView;
	}
	
	
	

	
}
