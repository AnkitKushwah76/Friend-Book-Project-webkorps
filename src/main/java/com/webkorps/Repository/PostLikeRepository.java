package com.webkorps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webkorps.model.PostLike;
import com.webkorps.model.User;
import com.webkorps.model.UserPost;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {

	public  PostLike findByUserPostAndUserId(@Param("userPostId") UserPost userPostId, @Param("userId") User userId);

	@Modifying
	@Query(value = "delete from post_like where user_post=:userPost and user_id=:userId",nativeQuery = true)
	public int dislike(@Param("userPost") UserPost userPost,@Param("userId") int userId);
	
			@Modifying
			@Query(value = "delete from post_like where user_post=:userpost",nativeQuery = true)
			public int deletelikepost(@Param("userpost") int userpost);
			


}
