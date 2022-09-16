package com.webkorps.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="userfollowers")
public class UserFollowers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userfollowers_id")
	private int id;
	
	private int user_id;
	
	@OneToOne
	@JoinColumn(name="follower")
	private User follower;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	@Override
	public String toString() {
		return "UserFollowers [id=" + id + ", user_id=" + user_id + ", follower=" + follower + "]";
	}

	
	
	
	
	
}
