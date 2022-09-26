package com.webkorps.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.webkorbs.service.FollowingService;
import com.webkorps.Repository.FollowingRepository;
import com.webkorps.model.Following;
@Service
public class FollowingServiceImpl implements FollowingService {
	
	@Autowired
	private FollowingRepository fllowingRepository;
	
	//increase following of user
		@Transactional
		public Following addfollowing(Following entity){
			return this.fllowingRepository.save(entity);
		}
		
		
		//this method is user for count following...
		@Override
		public int countFollowing(int id) {
			
			return this.fllowingRepository.countFollowing(id);
		}
		
		
		
		// get all following in particular...User..
		public List<Following> getAllFollwing(int userId){
			return (List<Following>) this.fllowingRepository.findAllFollowings(userId);
		}
		
		

}
