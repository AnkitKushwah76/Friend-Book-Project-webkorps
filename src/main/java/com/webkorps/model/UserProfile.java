package com.webkorps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="UserProfile")
public class UserProfile {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userProfileId;
	
	private String userImage;
	
	private String favoriteSongs;
	
	private String favoriteBooks;
	
	private String favoritePlaces;
	
	@OneToOne
	private User user;
	
	public UserProfile(int userProfileId, String userImage, String favoriteSongs, String favoriteBooks,
			String favoritePlaces, User user) {
		super();
		this.userProfileId = userProfileId;
		this.userImage = userImage;
		this.favoriteSongs = favoriteSongs;
		this.favoriteBooks = favoriteBooks;
		this.favoritePlaces = favoritePlaces;
		this.user = user;
	}
	
	
	

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	  @Override public String toString() { return "UserProfile [userProfileId=" +
	  userProfileId + ", userImage=" + userImage + ", favoriteSongs=" +
	  favoriteSongs + ", favoriteBooks=" + favoriteBooks + ", favoritePlaces=" +
	  favoritePlaces + ", user=" + user + "]"; }
	 

	

	}
