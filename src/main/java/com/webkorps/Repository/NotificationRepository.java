package com.webkorps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.model.Notification;
@Repository
public interface  NotificationRepository extends JpaRepository<Notification , Integer> {
	 

}
