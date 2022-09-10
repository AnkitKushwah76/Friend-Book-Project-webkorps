/*package com.webkorps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webkorbs.service.NotificationService;
import com.webkorps.model.Notification;

@Controller
public class FollowersController {
    
	@Autowired
	 private NotificationService notificationService;
	@GetMapping("/followes")
	public String followes(@ModelAttribute("id") String id,HttpSession session) {
		
		Integer userId=(Integer)session.getAttribute("userId");
		String followUserId=String.valueOf(userId);
		System.out.println("userId--->"+userId);
		System.out.println("followers-->"+id);
		Notification setNotificationData = this.notificationService.setNotificationData(followUserId, id);
		System.out.println("setNotificationData-->"+setNotificationData);
		return "User/userDashboard";
	}
}
*/