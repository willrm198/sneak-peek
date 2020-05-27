package com.example.sneakpeek;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<ClosetItem, String> {
	
	public List<ClosetItem> findByUserId(String userId);
	
	
}

