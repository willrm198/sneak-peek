package com.example.sneakpeek;

import java.util.List;

public class UserResponse {

	private String message;
	private List<User> users;

	public UserResponse(String message, List<User> users) {
		this.message = message;
		this.users = users;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
