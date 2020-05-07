package com.example.sneakpeek;

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
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/User/{userName}")
	public User getUserByFName(@PathVariable String userName) {
		return userRepository.findByUserName(userName);
	}

	@PostMapping(path = "/createUser", consumes = "application/json", produces = "application/json")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
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
