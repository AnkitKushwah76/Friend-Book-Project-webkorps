package com.webkorps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
	
	public UserProfile findByUserUserId(Integer id);
	public UserProfile findByUserProfileId(Integer id);
	@Query("from UserProfile as u where u.user.userId=:UserId")
	public UserProfile findUserProfileByUser(@Param("UserId") int userid );
	

}
