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
	
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemDescription() {
		return this.itemDescription;
	}
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public String getItemVisibility() {
		return this.itemVisibility;
	}
	
	public void setItemVisibility(String itemVisibility) {
		this.itemVisibility = itemVisibility;
	}
}