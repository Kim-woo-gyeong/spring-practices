package com.douzone.container.user;

import java.util.List;

public class User {
	private int no = 0;
	private String name = "김우경";
	private Friend friend;
	private List<String> friends;
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	//.xml에서 기본생성자로 만드는데 기본생성자가 없어서 오류가 발생했음.
	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}

	public User ( int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}
}
