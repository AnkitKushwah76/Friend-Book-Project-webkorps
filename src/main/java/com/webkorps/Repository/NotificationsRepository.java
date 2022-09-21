package com.webkorps.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.webkorps.model.Notifications;
@Repository
public interface NotificationsRepository extends CrudRepository<Notifications, Integer> {
	
	@Query(value="select * from notificatin where accept_user=:id and accept=:accept or (accept_user=:id and follow_back=:follow)",nativeQuery = true)
	public List<Notifications> findByUserId(@Param("id") int id,@Param("accept") boolean accept,@Param("follow") boolean follow);
	
	@Query(value="select * from notificatin where send_user_request=:id and accept_user=:acceptUser ",nativeQuery = true)
	public Notifications findByUserIdAndAccepted(@Param("id") int id,@Param("acceptUser") int acceptUser);
	
	@Modifying
	@Query(value="update notificatin set accept=:a where accept_user=:acceptUser and send_user_request=:userId",nativeQuery = true)
	public int updateAcceptRequest(@Param("a") boolean a,@Param("acceptUser") int acceptUser,@Param("userId") int userId);
	
	@Modifying
	@Query(value = "delete from notificatin where accept_user=:acceptUser and send_user_request=:userId",nativeQuery = true)
	public int followBack(@Param("acceptUser") int acceptUser,@Param("userId") int userId);
	
	
	
	
}
