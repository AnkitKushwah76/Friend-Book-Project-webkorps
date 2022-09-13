package com.webkorps.Repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.webkorps.model.UserFollower;
@Repository
public interface UserFollowerRepository extends CrudRepository<UserFollower, Integer> {

	
	@Query(value="select count(*) from userfollowers where user_id=:id",nativeQuery = true)
	public int countFollower(@Param("id") int id);
}
