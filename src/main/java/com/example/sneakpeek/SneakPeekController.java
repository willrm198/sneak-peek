package com.example.sneakpeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sneakpeek.UserRepository;

@RestController
public class SneakPeekController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/getUser")
	public User getUser(@RequestParam(value = "fName", defaultValue = "userFirst") String fName) {

		User user = userRepository.findByFirstName(fName);
		return user;
	}

	@PostMapping(path = "/createUser", consumes = "application/json", produces = "application/json")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
