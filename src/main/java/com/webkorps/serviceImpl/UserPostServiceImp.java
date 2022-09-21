package com.webkorps.serviceImpl;

import java.io.FileOutputStream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.webkorbs.service.UserPostService;
import com.webkorps.Repository.UserPostRepository;
import com.webkorps.model.User;
import com.webkorps.model.UserPost;

@Service
public class UserPostServiceImp implements UserPostService {

	@Autowired private UserPostRepository userPostRepository;
	
	
	// this method use for add post
	@Override
	public UserPost addPost(UserPost userPost, MultipartFile image, int userId) {

		String imageName = image.getOriginalFilename();
		try {
			InputStream inputStream = image.getInputStream();
			String path = "D:\\Spring-Boot-Projects\\Friend-Book-Project\\src\\main\\webapp\\view\\PostImage\\"+imageName;
			int bytes = 0;
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			while ((bytes = inputStream.read()) != -1)
				fileOutputStream.write(bytes);
			fileOutputStream.close();
			
			User user=new User();
			user.setId(userId);
			userPost.setImage(imageName);
			userPost.setUser(user);
			return this.userPostRepository.save(userPost);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//this method use for get all post particular...
	@Override
	public List<UserPost> getPost(int id) {
		
		return userPostRepository.findByUserId(id);
	}
	
	   //this method is use for count post...
			@Override
			public int countPost(int id) {
				return this.userPostRepository.countPost(id);
			}
			
			
			//get all post in followers
			public List<UserPost> getAllPost(Integer usersId){
				ArrayList<UserPost> user=new ArrayList<UserPost>();
				ArrayList<Integer> usersd=new ArrayList<Integer>(usersId);
				
				System.out.println("user--kushwah>"+usersd);
				System.out.println("userId-->"+usersId);
				for(int id:usersd) {
					List<UserPost> userPost=(List<UserPost>) this.userPostRepository.findByUserId(id);
					boolean addAll = user.addAll(userPost);
					System.out.println("addAll121231--"+addAll);
				}
				return user;
			}
			
		
			
			
}
