
package com.webkorps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webkorps.model.UserFollowers;

@Repository
public interface UserFollowerRepository extends CrudRepository<UserFollowers, Integer> {

	// count followers...
	@Query(value = "select count(*) from userfollowers where user_id=:id", nativeQuery = true)
	public int countFollower(@Param("id") int id);

	// get all followers in particular user....
	@Query("select uf from UserFollowers uf where uf.user_id=:userId")
	public List<UserFollowers> findAllFollowers(@Param("userId") int userId);
   
	@Modifying
	@Query(value = "delete from UserFollowers where follower=:follower",nativeQuery = true)
	public int unfollowUser(@Param("follower") int follower);
	
}
