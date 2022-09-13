package com.webkorps.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.stereotype.Service;

import com.webkorbs.service.UserFollowerService;

import com.webkorps.Repository.UserFollowerRepository;
import com.webkorps.model.UserFollower;

@Service
public class UserFollowerServiceImp implements UserFollowerService {

	@Autowired
	private UserFollowerRepository userFollowerRepository;

	// add follower of   user
	public UserFollower addFollower(UserFollower entity) {
		return this.userFollowerRepository.save(entity);
	}

	// this method is user for count follower..
	@Override
	public int countFollower(int id) {

		return this.userFollowerRepository.countFollower(id);
	}

}
