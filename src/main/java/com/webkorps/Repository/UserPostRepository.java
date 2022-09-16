package com.webkorps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webkorps.model.UserPost;

@Repository
public interface  UserPostRepository  extends  CrudRepository<UserPost, Integer> {

	//get all post in particular user...
	public List<UserPost> findByUserId(@Param("id") int id);
	
	//count all post
	@Query(value="select count(*) from posts where user_id=:id",nativeQuery = true)
	public int countPost(@Param("id") int id);
	
	@Modifying
	@Query(value="update posts set countpostlike=:userId where post_id=:id" ,nativeQuery = true)
	public int updateCountPostLike(@Param("userId") int userId,@Param("id")int id);
	
	
}
