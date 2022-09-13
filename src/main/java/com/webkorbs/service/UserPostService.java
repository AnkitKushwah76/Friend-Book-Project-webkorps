package com.webkorbs.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.webkorps.model.UserPost;

public interface UserPostService {
   
	// this method use for add post...
	public UserPost addPost(UserPost post, MultipartFile image, int userId);

	// get all post of particular users
	public List<UserPost> getPost(int id);

	//this method use for countPost...
	 public int countPost(int id);

}
