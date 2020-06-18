package com.example.sneakpeek;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ClosetItems")
public class ClosetItem {
	@Id
	public String itemId;

	public String userId;
	public Double itemSize;
	public String itemBrand;
	public String itemModel;
	public String itemDescription;
	public boolean itemIsVisible;

	public ClosetItem(String userId, Double itemSize, String itemBrand, String itemModel, String itemDescription,
			boolean itemIsVisible) {
		this.userId = userId;
		this.itemSize = itemSize;
		this.itemBrand = itemBrand;
		this.itemModel = itemModel;
		this.itemDescription = itemDescription;
		this.itemIsVisible = itemIsVisible;
	}

	public ClosetItem() {

	}

	public String getItemId() {
		return this.itemId;
	}

	public String getUserId() {
		return this.userId;
	}

	public String setUserId() {
		return this.userId;
	}

	public Double getItemSize() {
		return this.itemSize;
	}

	public void setItemUsSize(Double itemSize) {
		this.itemSize = itemSize;
	}

	public String getItemBrand() {
		return this.itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getItemModel() {
		return this.itemModel;
	}

	public void setItemModel(String itemModel) {
		this.itemModel = itemModel;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public boolean getitemIsVisible() {
		return this.itemIsVisible;
	}

	public void setitemIsVisible(boolean itemIsVisible) {
		this.itemIsVisible = itemIsVisible;
	}
}
