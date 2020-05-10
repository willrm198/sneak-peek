package com.example.sneakpeek;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sneakpeek.UserRepository;

@RestController
public class SneakPeekController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/User")
	public UserResponse getUsers(){
		List<User> users = userRepository.findAll();
		String message;
		
		if(users.size() == 0) {
			message = "No users found.";
		}
		else if(users.size() == 1) {
			message = "One user found.";
		}
		else if (users.size() > 1 && users.size() < 5) {
			message = "A few users found.";
		}
		else {
			message = "Many users found.";
		}
		return new UserResponse(message, users);
	}
	
	@GetMapping("/User/{userName}")
	public UserResponse getUserByFName(@PathVariable String userName) {
		List<User> list = new ArrayList<User>();
		list.add(userRepository.findByUserName(userName));
		
		return new UserResponse("User found." , list);
	}

	@PostMapping(path = "/createUser", consumes = "application/json", produces = "application/json")
	public String createUser(@RequestBody User user) {
		userRepository.save(user);
		return String.format("User %s created!", user.getUserName().toUpperCase());
	}
	
	@PutMapping(path = "/User/{userName}", consumes = "application/json", produces = "application/json")
	public void updateUser(@RequestBody User user, @PathVariable String userName) {
		User oldUser = userRepository.findByUserName(userName);
		
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		oldUser.setCloset(user.getCloset());
		
		userRepository.save(oldUser);
	}
	
	@DeleteMapping(path = "/User/{userName}")
	public void deleteUser(@PathVariable String userName) {
		String id = userRepository.findByUserName(userName).getId();
		userRepository.deleteById(id);
	}
}


//Make sure POST can read the body of a request -- validate by sending a body back with a 200 response, 
//that ALL CAPS some value in the request body (i.e. request contains {name: 'sheree', age: 56}, response 
//		should contain at minimum {name: "SHEREE"})