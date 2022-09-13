package com.webkorps.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webkorps.model.Following;
@Repository
public interface  FollowingRepository  extends CrudRepository<Following,Integer>{
	
	@Query(value="select count(*) from following where user_id=:id",nativeQuery = true)
	public int countFollowing(@Param("id") int id);
	
	@Query(value="select f from Following f where f.user_id=:userId")
	public List<Following> findAllFollowings(@Param("userId") int userId);
	
	

}
