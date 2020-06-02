package com.example.sneakpeek;

public class ClosetRequest {
	
	private String username;
	private ClosetItem closetItem;
	
	public ClosetRequest() {
		
	}
	
	public ClosetRequest(String username, ClosetItem closetItem) {
		this.username = username;
		this.closetItem = closetItem;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setClosetItem(ClosetItem closetItem) {
		this.closetItem = closetItem;
	}
	
	public ClosetItem getClosetItem() {
		return this.closetItem;
	}
}
