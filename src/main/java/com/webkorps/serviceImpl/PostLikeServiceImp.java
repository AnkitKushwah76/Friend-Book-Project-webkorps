package com.webkorps.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpSessionRequiredException;

import com.webkorbs.service.PostLikeService;
import com.webkorps.Repository.PostLikeRepository;
import com.webkorps.Repository.UserPostRepository;
import com.webkorps.model.PostLike;
import com.webkorps.model.User;
import com.webkorps.model.UserPost;
@Service
public class PostLikeServiceImp implements PostLikeService{

	@Autowired
	public PostLikeRepository postLikeRepository;
	@Autowired
	public UserPostRepository userPostRepository;
	@Override
	@Transactional
	public boolean addPostLike(int userPostId, int userId1) {
	
		PostLike postLike=new PostLike();
		UserPost userPost=new UserPost();
		
		  userPost.setId(userPostId);
            postLike.setUserPost(userPost);
            User user=new User();
            user.setId(userId1);
            postLike.setUserId(user);
            postLike.setStatus(true);
            //postLikeRepository.updatestatus(true, userPostId);
            if(postLikeRepository.save(postLike)!=null)
            {
            	return true;
            }
            
				//           int countPostLike = postLikeRepository.countPostLike(userPostId);
				//           System.out.println("countPostLike--->"+countPostLike);
				//           
				//            int updateCountPostLike = userPostRepository.updateCountPostLike(countPostLike,userPostId);
				//           System.out.println("updateCountPostLike---++"+updateCountPostLike);
		return false;
	}


	
	
}
