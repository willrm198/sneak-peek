package com.example.sneakpeek;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {

	public String itemType;
	public String itemName;
	public String itemDescription;
	public String itemVisibility;

	public Item(String itemType, String itemName, String itemDescription, String itemVisibility) {
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemVisibility = itemVisibility;
	}
	
	public Item() {
		
	}
	
	public String getItemType() {
		return this.itemType;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public String getItemDescription() {
		return this.itemDescription;
	}
	
	public String getItemVisibility() {
		return this.itemVisibility;
	}
}