package com.webkorps.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;



@Entity
@Table(name="UserDetails")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int userId;
	private String fullName;
	private String userEmail;
	
	private String userPassword;
	
	private String userName;
	
	private String role;

	@JoinColumn(name="userId")
	@OneToOne(cascade = CascadeType.ALL)

	private UserProfile userProfile;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Followers>followers;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Followings>followings;


	



	public User(int userId, String fullName, String userEmail, String userPassword, String userName, String role,
			UserProfile userProfile, List<Followers> followers, List<Followings> followings) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.role = role;
		this.userProfile = userProfile;
		this.followers = followers;
		this.followings = followings;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public List<Followers> getFollowers() {
		return followers;
	}



	public void setFollowers(List<Followers> followers) {
		this.followers = followers;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userName=" + userName + ", role=" + role + ", userProfile=" + userProfile
				+ ", followers=" + followers + ", followings=" + followings + "]";
	}

	



	

	
	
	

	
	
	
	

}
