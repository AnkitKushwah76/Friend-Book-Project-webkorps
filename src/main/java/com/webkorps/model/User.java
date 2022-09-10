package com.webkorps.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="UserDetails")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	

	private String fullName;
	private String userEmail;
	
	private String userPassword;
	@Column(nullable = true)
	private String userName;
	@Column(nullable = true)
	private String userImage;
	
	@Column(nullable = true)
	private String favoriteSongs;
	
	@Column(nullable = true)
	private String favoriteBooks;
	
	@Column(nullable = true)
	private String favoritePlaces;
	@Column(nullable = true)
	private boolean  status;

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Followers>followers;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Followings>followings;


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}


	public String getFavoriteSongs() {
		return favoriteSongs;
	}
	public void setFavoriteSongs(String favoriteSongs) {
		this.favoriteSongs = favoriteSongs;
	}
   public String getFavoriteBooks() {
		return favoriteBooks;
	}

	public void setFavoriteBooks(String favoriteBooks) {
		this.favoriteBooks = favoriteBooks;
	}

	public String getFavoritePlaces() {
		return favoritePlaces;
	}

  public void setFavoritePlaces(String favoritePlaces) {
		this.favoritePlaces = favoritePlaces;
	}

	public List<Followers> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Followers> followers) {
		this.followers = followers;
	}

	public List<Followings> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Followings> followings) {
		this.followings = followings;
	}





	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userName=" + userName + ", userImage=" + userImage + ", favoriteSongs="
				+ favoriteSongs + ", favoriteBooks=" + favoriteBooks + ", favoritePlaces=" + favoritePlaces
				+ ", status=" + status + ", followers=" + followers + ", followings=" + followings + "]";
	}



	

	
	}
