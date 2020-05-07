package com.example.sneakpeek;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class User {

	@Id
	private String id;

	@Indexed(unique=true)
	private String userName;
	
	private String firstName;
	private String lastName;
	private ArrayList<Item> closet;
	

	public User(String firstName, String lastName, String userName, ArrayList<Item> closet) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.closet = closet;
	}
	
	public User() {
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}
	
	public ArrayList<Item> getCloset(){
		return this.closet;
	}
	
	public void setCloset(ArrayList<Item> closet) {
		this.closet = closet;
	}
	
	@Override
	public String toString() {
		return String.format("User[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
