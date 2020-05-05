package com.example.sneakpeek;

import java.util.List;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;

	private String firstName;
	private String lastName;
	private List<Item> closet;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return String.format("User[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
