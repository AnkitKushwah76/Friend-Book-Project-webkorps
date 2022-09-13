package com.webkorbs.dto;

import java.util.List;

import com.webkorps.model.Following;
import com.webkorps.model.User;
import com.webkorps.model.UserFollower;
import com.webkorps.model.UserPost;

public class UserProfileDto {
	
	private int countFollowers;
	private int countFollowing;
	private int countPost;
	
	private List<UserFollower> userFollower;
	
	private List<Following> userFollowing;
	
     private User user;
     
	private List<UserPost> getAllPost;
	
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
	public List<UserPost> getGetAllPost() {
		return getAllPost;
	}
	public void setGetAllPost(List<UserPost> getAllPost) {
		this.getAllPost = getAllPost;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCountPost() {
		return countPost;
	}
	public void setCountPost(int countPost) {
		this.countPost = countPost;
	}
	public List<UserFollower> getUserFollower() {
		return userFollower;
	}
	public void setUserFollower(List<UserFollower> userFollower) {
		this.userFollower = userFollower;
	}
	public List<Following> getUserFollowing() {
		return userFollowing;
	}
	public void setUserFollowing(List<Following> userFollowing) {
		this.userFollowing = userFollowing;
	}
	@Override
	public String toString() {
		return "UserProfileDto [countFollowers=" + countFollowers + ", countFollowing=" + countFollowing
				+ ", countPost=" + countPost + ", userFollower=" + userFollower + ", userFollowing=" + userFollowing
				+ ", user=" + user + ", getAllPost=" + getAllPost + "]";
	}
	
	

}
