package com.webkorbs.service;

import java.util.List;

import com.webkorps.model.UserFollowers;

public interface UserFollowerService {

	public int countFollower(int id);

	// get user followers
	public List<UserFollowers> getAllFollower(int userId);

}
