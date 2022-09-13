package com.webkorbs.dto;

import java.util.List;

import com.webkorps.model.Following;
import com.webkorps.model.UserPost;

public class UserDashboardDto {
	
	private List<Following> following;
	private List<UserPost> posts;
	public List<Following> getFollowing() {
		return following;
	}
	public void setFollowing(List<Following> following) {
		this.following = following;
	}
	public List<UserPost> getPosts() {
		return posts;
	}
	public void setPosts(List<UserPost> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "UserDashboardDto [following=" + following + ", posts=" + posts + "]";
	}
	
	
	

}
