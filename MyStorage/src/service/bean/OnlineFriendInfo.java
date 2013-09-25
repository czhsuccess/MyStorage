package service.bean;

import java.io.Serializable;

public class OnlineFriendInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	long uid;
	String[] friendList;
	
	public synchronized long getUid() {
		return uid;
	}
	public synchronized void setUid(long uid) {
		this.uid = uid;
	}
	public synchronized String[] getFriendList() {
		return friendList;
	}
	public synchronized void setFriendList(String[] friendList) {
		this.friendList = friendList;
	}
}
