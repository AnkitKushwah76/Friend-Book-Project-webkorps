package com.webkorps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class UserPost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postId")
	private int id;
	private String description;
	private String image;


	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "userPost")
	private List<PostLike> postlike;
	@OneToMany(mappedBy = "userPost")
	private List<Comments> comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PostLike> getPostlike() {
		return postlike;
	}

	public void setPostlike(List<PostLike> postlike) {
		this.postlike = postlike;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "UserPost [id=" + id + ", description=" + description + ", image=" + image + ", user=" + user
				+ ", postlike=" + postlike + ", comments=" + comments + "]";
	}

	

	
	
}
