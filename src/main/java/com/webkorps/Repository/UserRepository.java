package com.webkorps.Repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webkorps.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// public User findByUserEmailAndUserPassword(String email,String password);
	public User findByUserEmailAndUserPassword(@Param("email") String email, @Param("password") String password);

	public User findByUserEmail(@Param("email") String email);

	@Modifying
	@Query(value = "update user_details set status=false where id=:id", nativeQuery = true)
	public int updateById(@Param("id") int id);

	@Query("select u from User u where u.userEmail=:email")
	public User getUserByUserName(@Param("email") String email);
	public User findByid(Integer id);


	@Query("select u from User u where u.userName=:userName")
	public User UserByUserName(@Param("userName") String userName);

	public List<User> findByUserNameContains(String search);

}
