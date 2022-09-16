package com.webkorps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webkorps.model.PostLike;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {

	@Query(value = "select count(*) from post_like where user_post=:id", nativeQuery = true)
	public int countPostLike(@Param("id") int id);

	
//	@Modifying
//	@Query(value="update post_like set status=:a where user_post=:userid",nativeQuery = true)
//	public int updatestatus(@Param("a") boolean a,@Param("userid") int userid);
//	
}
