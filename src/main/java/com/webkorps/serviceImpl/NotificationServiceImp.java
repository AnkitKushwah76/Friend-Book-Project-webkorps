/*package com.webkorps.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorbs.service.NotificationService;
import com.webkorps.Repository.NotificationRepository;
import com.webkorps.model.Notification;
@Service
public class NotificationServiceImp  implements NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public Notification setNotificationData(String id, String userId) {
		
		     Notification notification=new Notification();
		     
		     notification.setAcceptRequest(userId);
		     notification.setSendRequest(id);
		     notification.setIsAccept("false");
		     notification.setIsFollow("false");
		     notification.setStatus("true");
		     
		     this.notificationRepository.save(notification);
		
		return notification;
	}
	

}
*/
