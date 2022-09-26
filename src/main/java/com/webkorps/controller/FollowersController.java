
package com.webkorps.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.webkorps.Repository.NotificationsRepository;
import com.webkorps.Repository.UserFollowerRepository;
import com.webkorps.serviceImpl.NotificationImpl;

@Controller
public class FollowersController {

	@Autowired
	private NotificationImpl notificationImpl;

	@Autowired
	private NotificationsRepository notificationsRepository;

	@Autowired
	private UserFollowerRepository userFollowerRepository;

	// follow request
	@Transactional
	@GetMapping("/followrequest")
	public ModelAndView SendRequest(@ModelAttribute("id") int userId, HttpServletRequest req, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = req.getSession();
		if (this.notificationsRepository.findByUserIdAndAccepted((int) session.getAttribute("userId"),
				userId) != null) {
			notificationsRepository.followBack(userId, (int) session.getAttribute("userId"));
			session.setAttribute("alreadyfollow", "request cancel successfully..!!");
			modelAndView.setViewName("userDashboard");
			return modelAndView;

		} else {
			this.notificationImpl.addRequest(userId, (int) session.getAttribute("userId"));
			session.setAttribute("succMsg", "Request Sent To The User...");
			modelAndView.setViewName("userDashboard");
			return modelAndView;
		}
	}

	@GetMapping("/checkUserRequest")
	public ModelAndView checkRequest(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = req.getSession();
		// get all follow request
		modelAndView.addObject("request", this.notificationImpl.getRequest((int) session.getAttribute("userId")));
		session.setAttribute("succMsg", req.getAttribute("succMsg"));
		modelAndView.setViewName("Friendsrequests");
		return modelAndView;
	}

	// accept follow request
	@GetMapping("/acceptrequest")
	public RedirectView acceptRequest(@RequestParam("userId") int userId, HttpServletRequest req) {
		RedirectView rd = new RedirectView();
		HttpSession session = req.getSession();
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
		this.notificationImpl.followBack((int) session.getAttribute("userId"), userId);
		redirecatView.setUrl("checkUserRequest");
		return redirecatView;
	}

	@GetMapping("/declinerequest")
	@Transactional
	public RedirectView declinerequest(@RequestParam("userId") int userId, HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		HttpSession session = request.getSession();
		notificationsRepository.followBack((int) session.getAttribute("userId"), userId);
		redirectView.setUrl("checkUserRequest");
		return redirectView;
	}

	@Transactional
	@GetMapping("/unfollow")
	public RedirectView unfollow(@RequestParam("unfollowId") int unfollowId, HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		HttpSession session = request.getSession();
		this.userFollowerRepository.unfollowUser(unfollowId);
		this.notificationsRepository.followBack((int) session.getAttribute("userId"), unfollowId);
		redirectView.setUrl("showUserProfile");
		return redirectView;
	}

}
