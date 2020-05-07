package com.example.sneakpeek;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByUserName(String userName);

	public List<User> findByLastName(String lastName);
	
}
