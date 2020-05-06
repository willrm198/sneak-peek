package com.example.sneakpeek;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class User {

	@Id
	private String id;

	private String firstName;
	private String lastName;
	private ArrayList<Item> closet;
	

	public User(String firstName, String lastName, ArrayList<Item> closet) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.closet = closet;
	}
	
	public User() {
		
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public ArrayList<Item> getCloset(){
		return this.closet;
	}
	
	@Override
	public String toString() {
		return String.format("User[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
