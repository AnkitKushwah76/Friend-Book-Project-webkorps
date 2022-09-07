package com.webkorps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.webkorps.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public List<User> findByUserEmailAndUserPassword(String email,String password);
	
	public User findByUserId(Integer id);
	
	//@Query("select u from User u where u.email=:email")
	//public  User getUserByUserName(@Param("email")String email);
	
	@Query("select u from User u where u.userEmail=:email")
	public User getUserByUserName(@Param("email")String email);
	
    
	

}
