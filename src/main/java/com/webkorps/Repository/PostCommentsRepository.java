package com.webkorps.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.model.Comments;
import com.webkorps.model.UserPost;
public interface PostCommentsRepository extends JpaRepository<Comments, Integer>  {
	
	   //get all comments in particular user...
		public List<Comments> findByUserPost(@Param("id") UserPost id);

		@Modifying
		@Query(value = "delete from comments where user_post=:userpost",nativeQuery = true)
		public int deleteComments(@Param("userpost") int userpost);
				

}
