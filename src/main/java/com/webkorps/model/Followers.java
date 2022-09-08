package com.webkorps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Followers  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String followers ;
	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFollowers() {
		return followers;
	}

	public void setFollowers(String followers) {
		this.followers = followers;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Followers(int id, String followers, String userfollowers, User user) {
		super();
		this.id = id;
		this.followers = followers;
		
		this.user = user;
	}

	@Override
	public String toString() {
		return "Followers [id=" + id + ", followers=" + followers + ", user=" + user + "]";
	}

	
	
	

}
