package com.webkorps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Followings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String followings ;
	
	@ManyToOne
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFollowings() {
		return followings;
	}
	public void setFollowings(String followings) {
		this.followings = followings;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Followings(int id, String followings, String userfollowings, User user) {
		super();
		this.id = id;
		this.followings = followings;
		
		this.user = user;
	}
	@Override
	public String toString() {
		return "Followings [id=" + id + ", followings=" + followings + ", user=" + user + "]";
	}
	
	
	
	

}
