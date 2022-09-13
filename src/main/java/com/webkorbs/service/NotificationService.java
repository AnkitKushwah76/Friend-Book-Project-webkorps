package com.webkorbs.service;

import java.util.List;



import com.webkorps.model.Notifications;



public interface NotificationService {

	// add follow request
	public String addRequest(int userId, int sesssionUserId);

	// get all request
	public List<Notifications> getRequest(int id);

}
