package com.example.sneakpeek;

import java.util.List;

public class ClosetResponse {

	private String message;
	private List<ClosetItem> closet;

	public ClosetResponse(String message, List<ClosetItem> closet) {
		this.message = message;
		this.closet = closet;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ClosetItem> getCloset() {
		return this.closet;
	}

	public void setCloset(List<ClosetItem> closet) {
		this.closet = closet;
	}
}
