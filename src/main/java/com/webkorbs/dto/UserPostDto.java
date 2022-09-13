package com.webkorbs.dto;

import com.webkorps.model.User;

public class UserPostDto {
	
	int userPostId;
	private String postImage;
	private String postDescription;
	
	private User user;

	public int getUserPostId() {
		return userPostId;
	}

	public void setUserPostId(int userPostId) {
		this.userPostId = userPostId;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPostDto [userPostId=" + userPostId + ", postImage=" + postImage + ", postDescription="
				+ postDescription + ", user=" + user + "]";
	}
	
	
	
	
	
}
	
	