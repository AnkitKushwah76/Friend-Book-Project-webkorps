package com.webkorbs.service;

import com.webkorps.model.Following;

public interface FollowingService {

	// increase following of user
	public Following addfollowing(Following entity);

	// this method is use for count following
	public int countFollowing(int id);

}
