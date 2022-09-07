package com.webkorps.serviceImpl;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.webkorbs.service.UserService;
import com.webkorps.Repository.UserProfileRepository;
import com.webkorps.Repository.UserRepository;
import com.webkorps.model.User;
import com.webkorps.model.UserProfile;

@Service 
public class UserServiceImp implements UserService{

	@Autowired private UserRepository userRepository;
	
	 @Autowired
	 private UserProfileRepository userProfileRepository;
	
	@Override
	public User userSignup(User user) {
		
		user.setRole("ROLE_USER");
		
		  String fullName = user.getFullName();
		  String use = generatUsername(fullName);
			 user.setUserName(use);
		  User usr = this.userRepository.save(user);
		  
		 
		
		return usr;
	}
	
	public String generatUsername(String fullName)
	{
		Random random=new Random();
		int index=fullName.indexOf(' ');
		String num=100+random.nextInt(899)+"";
		String userName=fullName.substring(0,1).toUpperCase()+fullName.substring(1,index)+num;
		System.out.println("userName-->"+userName);
		return userName;
	}


	@Override
	public String userLogin(User user,Model model,HttpSession session) {
		
		
		 String userEmail = user.getUserEmail();
		 String userPassword = user.getUserPassword();
		List<User> check = this.userRepository.findByUserEmailAndUserPassword(userEmail, userPassword); 
		
		if(check.size()!=0)
		{
			for(User o:check)
		     {
		    	 System.out.println("o->>"+o.getUserId());
		    	 session.setAttribute("userId", o.getUserId());
		    	 session.setAttribute("userEmail", o.getUserEmail());
		    	 session.setAttribute("userName", o.getUserName());
		    	 //model.addAttribute("userName",o.getUserName());
		     }
			model.addAttribute("sucessfully","Login SucessFully !! ");
			int id=	(int) session.getAttribute("userId");
			UserProfile findByUserUserId = this.userProfileRepository.findByUserUserId(id);
			
			System.out.println("findByUserUserId-->"+findByUserUserId);
			 if(findByUserUserId!=null)
			 {
				 System.out.println("if");
				 
				 return "signup" ;
			 }
			 
			 else {
				 System.out.println("else");
				
				 return "UserProfile";
			 }
		}
		else {
			System.out.println("erro--else");
			model.addAttribute("error","Invalid username and password !! ");
			
			return "login";
		}
		
		
		
		//return ( List<User>)check;
	}

	
	
	

}
