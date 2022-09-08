package com.webkorbs.service;

import org.springframework.stereotype.Service;

import com.webkorps.model.Notification;

public interface NotificationService {
	
	public Notification setNotificationData(Integer id,String userId);

}
