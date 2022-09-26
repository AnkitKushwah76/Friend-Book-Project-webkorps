package com.webkorps.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class PostLike {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	
	@OneToOne
	@JoinColumn(name="userId")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name="userPost")
	private UserPost userPost;

	
	public boolean status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public UserPost getUserPost() {
		return userPost;
	}

	public void setUserPost(UserPost userPost) {
		this.userPost = userPost;
	}

	
	public boolean isStatus() {
	return status;
}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PostLike [status=" + status + "]";
	}

	
//	@Override
//	public String toString() {
//		return "PostLike [id=" + id + ", userId=" + userId + ", userPost=" + userPost + ", status=" + status + "]";
//	}


	
	

	
}
