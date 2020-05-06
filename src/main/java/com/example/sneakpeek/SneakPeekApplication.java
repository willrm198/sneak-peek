package com.example.sneakpeek;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SneakPeekApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(SneakPeekApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userRepos.deleteAll();
		System.out.println("_____DELETE ALL_____");
		
		ArrayList<Item> list = new ArrayList<Item>();
		Item item = new Item("shoe", "Adidas", "This is a description", "public");
		list.add(item);
		
		User user = new User("Frank", "Coleman", list);
		
		userRepos.save(user);
		System.out.println("_____USER SAVED_____");
	}
}
