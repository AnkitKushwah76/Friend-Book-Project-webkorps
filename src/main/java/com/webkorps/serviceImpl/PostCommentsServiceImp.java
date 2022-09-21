package com.webkorps.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorbs.service.PostCommentsService;
import com.webkorps.Repository.PostCommentsRepository;
import com.webkorps.model.Comments;
import com.webkorps.model.User;
import com.webkorps.model.UserPost;
@Service
public class PostCommentsServiceImp implements PostCommentsService{

	@Autowired
	private PostCommentsRepository postCommentsRepository;
	
	
		public boolean addComment(int userId,int postId,String comment) {
			  UserPost userPost=new UserPost();
			  userPost.setId(postId);
			  System.out.println(userPost.getId());
			  User user=new User();
			   user.setId(userId);
			   System.out.println(user.getId());
			   Comments comments=new Comments();
			   comments.setUserPost(userPost);
			   comments.setUser(user);
			   comments.setComment(comment);
			  
			   this. postCommentsRepository.save(comments);
			  
			 return false;
		}
		
  public  List<Comments> getallComments(int postId)
   {
	   UserPost userpost=new UserPost();
	      userpost.setId(postId);
	       List<Comments> findByUserPost = this.postCommentsRepository.findByUserPost(userpost);
	      
	      System.out.println("findByUserPost---->"+findByUserPost);
	   return findByUserPost;
   }
}
