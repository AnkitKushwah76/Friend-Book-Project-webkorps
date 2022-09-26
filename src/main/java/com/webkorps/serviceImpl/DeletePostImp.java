package com.webkorps.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.Repository.PostCommentsRepository;
import com.webkorps.Repository.PostLikeRepository;
import com.webkorps.Repository.UserPostRepository;

@Service
public class DeletePostImp {
	
	@Autowired private PostCommentsRepository postCommentsRepository;
    @Autowired private PostLikeRepository postLikeRepository;
    @Autowired private UserPostRepository userPostRepository;
	 
	@Transactional
	public void userDeletePost(int postId){
		 this.postCommentsRepository.deleteComments(postId);
		 this.postLikeRepository.deletelikepost(postId);
		 this.userPostRepository.deleteById(postId);
		
	}

}
