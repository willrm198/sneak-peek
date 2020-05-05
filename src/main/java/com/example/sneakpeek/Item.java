package com.example.sneakpeek;

import org.springframework.data.annotation.Id;

public class Item {

	@Id
	public String id;

	public String userId;
	public String itemType;
	public String itemName;
	public String itemDescription;
	public String itemVisibility;

	public Item(String userId, String itemType, String itemName, String itemDescription, String itemVisibility) {
		this.userId = userId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemVisibility = itemVisibility;
	}
}