package com.webkorps.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="notificatin")
public class Notifications {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int acceptUser;
	
	@OneToOne
	@JoinColumn(name="sendUserRequest")
	private User sendUserRequest;
	
	private boolean accept;
	private boolean followBack;
	
	public boolean getFollowBack() {
		return followBack;
	}

	public void setFollowBack(boolean followBack) {
		this.followBack = followBack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcceptUser() {
		return acceptUser;
	}

	public void setAcceptUser(int acceptUser) {
		this.acceptUser = acceptUser;
	}

	public User getSendUserRequest() {
		return sendUserRequest;
	}

	public void setSendUserRequest(User sendUserRequest) {
		this.sendUserRequest = sendUserRequest;
	}

	public boolean getAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	@Override
	public String toString() {
		return "Notifications [id=" + id + ", acceptUser=" + acceptUser + ", sendUserRequest=" + sendUserRequest
				+ ", accept=" + accept + ", followBack=" + followBack + "]";
	}

	

	
	
	
	
}
