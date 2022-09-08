package com.webkorps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Nid;
	String acceptRequest;
	String sendRequest;
	String isAccept;
	String isFollow;
	public int getNid() {
		return Nid;
	}
	public void setNid(int nid) {
		Nid = nid;
	}
	public String getAcceptRequest() {
		return acceptRequest;
	}
	public void setAcceptRequest(String acceptRequest) {
		this.acceptRequest = acceptRequest;
	}
	public String getSendRequest() {
		return sendRequest;
	}
	public void setSendRequest(String sendRequest) {
		this.sendRequest = sendRequest;
	}
	public String getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(String isAccept) {
		this.isAccept = isAccept;
	}
	public String getIsFollow() {
		return isFollow;
	}
	public void setIsFollow(String isFollow) {
		this.isFollow = isFollow;
	}
	@Override
	public String toString() {
		return "Notification [Nid=" + Nid + ", acceptRequest=" + acceptRequest + ", sendRequest=" + sendRequest
				+ ", isAccept=" + isAccept + ", isFollow=" + isFollow + "]";
	}
	
	
	
	
	

}
