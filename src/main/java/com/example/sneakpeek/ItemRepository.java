package com.example.sneakpeek;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String>{
	public Item findByItemName(String itemName);
}
