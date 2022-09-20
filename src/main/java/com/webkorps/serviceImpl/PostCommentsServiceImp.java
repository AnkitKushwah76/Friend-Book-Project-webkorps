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
			 System.out.println("userId-->"+userId);
			 System.out.println("postId--->"+postId);
			 System.out.println("comments--->"+comment);
			 UserPost userPost =new UserPost();
			 Comments comments=new Comments();
			 User user =new User();
			 user.setId(userId);
			 userPost.setId(postId);
			 comments.setUser(user);
			 comments.setUserPost(userPost);
			 comments.setComment(comment);
			Comments save = this. postCommentsRepository.save(comments);
			System.out.println("Comments save-->"+save);
			if(save!=null)
			{
				return true;
			}
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
