package com.webkorbs.dto;

import java.util.List;



import com.webkorps.model.Following;
import com.webkorps.model.PostLike;
import com.webkorps.model.User;
import com.webkorps.model.UserFollowers;
import com.webkorps.model.UserPost;

public class UserProfileDto {
	
	private int countFollowers;
	private int countFollowing;
	private int countPost;
	
	private List<UserFollowers> userFollowers;
	
	private List<Following> userFollowing;
	
     private User user;
     
	private List<UserPost> getAllPost;
	
	private List<UserPost>getAllFollowerPost;
	
	private int   countPostLike;
	
	

	

	public int getCountPostLike() {
		return countPostLike;
	}

	public void setCountPostLike(int countPostLike) {
		this.countPostLike = countPostLike;
	}

	public int getCountFollowers() {
		return countFollowers;
	}

	public void setCountFollowers(int countFollowers) {
		this.countFollowers = countFollowers;
	}

	public int getCountFollowing() {
		return countFollowing;
	}

	public void setCountFollowing(int countFollowing) {
		this.countFollowing = countFollowing;
	}

	public int getCountPost() {
		return countPost;
	}

	public void setCountPost(int countPost) {
		this.countPost = countPost;
	}

	public List<UserFollowers> getUserFollowers() {
		return userFollowers;
	}

	public void setUserFollowers(List<UserFollowers> userFollowers) {
		this.userFollowers = userFollowers;
	}

	public List<Following> getUserFollowing() {
		return userFollowing;
	}

	public void setUserFollowing(List<Following> userFollowing) {
		this.userFollowing = userFollowing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserPost> getGetAllPost() {
		return getAllPost;
	}

	public void setGetAllPost(List<UserPost> getAllPost) {
		this.getAllPost = getAllPost;
	}

	public List<UserPost> getGetAllFollowerPost() {
		return getAllFollowerPost;
	}

	public void setGetAllFollowerPost(List<UserPost> getAllFollowerPost) {
		this.getAllFollowerPost = getAllFollowerPost;
	}

	@Override
	public String toString() {
		return "UserProfileDto [countFollowers=" + countFollowers + ", countFollowing=" + countFollowing
				+ ", countPost=" + countPost + ", userFollowers=" + userFollowers + ", userFollowing=" + userFollowing
				+ ", user=" + user + ", getAllPost=" + getAllPost + ", getAllFollowerPost=" + getAllFollowerPost
				+ ", countPostLike=" + countPostLike + "]";
	}

	
	

	
	
	
		
	
}
