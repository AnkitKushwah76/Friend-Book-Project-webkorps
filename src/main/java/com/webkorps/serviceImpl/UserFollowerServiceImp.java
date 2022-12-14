package com.webkorps.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webkorbs.service.UserFollowerService;
import com.webkorps.Repository.UserFollowerRepository;
import com.webkorps.model.UserFollowers;
@Service
public class UserFollowerServiceImp implements UserFollowerService {

	@Autowired
	private UserFollowerRepository userFollowerRepository;

	// add follower of user
	public UserFollowers addFollower(UserFollowers entity) {
		return this.userFollowerRepository.save(entity);
	}

	// this method is user for count follower..
	@Override
	public int countFollower(int id) {
      return this.userFollowerRepository.countFollower(id);
	}

	// get all followers in particular...User..
	@Override
	public List<UserFollowers> getAllFollower(int userId) {
		//List<UserFollowers> findAllFollowers = userFollowerRepository.findAllFollowers(userId);
         return userFollowerRepository.findAllFollowers(userId);
	}

}
