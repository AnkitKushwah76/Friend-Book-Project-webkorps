/*package com.webkorps.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webkorps.model.Notification;

@Repository
public interface  NotificationRepository extends JpaRepository<Notification , Integer> {
	 
	@Query("select u from Notification u where u.acceptRequest=:acceptRequest And u.status='true'")
    public Notification findByuser(@Param("acceptRequest")String acceptRequest);
}
*/
