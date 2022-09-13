package com.webkorps.serviceImpl;


import java.util.List;


import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.webkorbs.service.NotificationService;

import com.webkorps.Repository.NotificationsRepository;
import com.webkorps.model.Following;
import com.webkorps.model.Notifications;

import com.webkorps.model.User;
import com.webkorps.model.UserFollower;

@Service
public class NotificationImpl implements NotificationService {

	@Autowired
	private NotificationsRepository notificationsRepository;

	@Autowired
	private FollowingServiceImpl followingServiceImpl;

	@Autowired
	private UserFollowerServiceImp userFollowerServiceImp;

	// add follow request
	@Override
	public String addRequest(int userId, int sesssionUserId) {
		Notifications notificatin = new Notifications();
		User user = new User();
		user.setId(sesssionUserId);
		notificatin.setAccept(false);
		notificatin.setFollowBack(false);
		notificatin.setSendUserRequest(user);
		notificatin.setAcceptUser(userId);
		if (this.notificationsRepository.save(notificatin) != null)
			return "success";
		else
			return "fail";

	}

	// get all follow request
	public List<Notifications> getRequest(int id) {
		boolean accept = false;
		boolean follow = false;
		return this.notificationsRepository.findByUserId(id, accept, follow);
	}
	
	public Notifications getFollowerRequest(int userId,int acceptUser){
		return this.notificationsRepository.findByUserIdAndAccepted(userId,acceptUser);
	}
	
	// accept request
	@Transactional
	public int accept(int acceptUser, int userId) {
		boolean a = true;

		if (this.notificationsRepository.updateAcceptRequest(a, acceptUser, userId) > 0) {
			UserFollower userFollower = new UserFollower();
			User user = new User();
			user.setId(userId);
			userFollower.setFollower(user);
			userFollower.setUser_id(acceptUser);

			Following following = new Following();
			User user1 = new User();
			user1.setId(acceptUser);

			following.setFollowing(user1);
			following.setUser_id(userId);

			
			if (this.followingServiceImpl.addfollowing(following) != null
					&& this.userFollowerServiceImp.addFollower(userFollower) != null)
				return 1;
		}

		return 0;
	}
	
	
	//followBack...
	@Transactional
	public boolean followBack(int acceptedUser,int userId) {
		
		
		System.out.println("accceptedUser-->"+acceptedUser);
		System.out.println("userid--->"+userId);
		if(this.notificationsRepository.followBack(acceptedUser, userId)>0) {
			
			Notifications notification= new Notifications();
			User user=new User();
		     user.setId(acceptedUser);
			notification.setAccept(false);
			notification.setFollowBack(true);
			notification.setSendUserRequest(user);
			notification.setAcceptUser(userId);
			if(this.notificationsRepository.save(notification)!=null)
				return true;
				
		}
		
		return false;
	}

}
