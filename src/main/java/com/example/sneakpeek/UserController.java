package com.example.sneakpeek;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sneakpeek.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Gets a list of all users
	 * @param sortField - the field to sort list by
	 * @param sortDir - the direction to sort list
	 * @return response object containing a message and sorted list of users
	 */
	@GetMapping("/User")
	public UserResponse getUsers(
			@RequestParam(name = "sortField", required = false, defaultValue = "username") String sortField,
			@RequestParam(name = "sortDir", required = false, defaultValue = "asc") String sortDir) {
		List<User> users = userRepository.findAll();
		String message = users.isEmpty() ? "No users found." : "User(s) found!";

		List<User> sortedList = sortUsers(users, sortField, sortDir);
		return new UserResponse(message, sortedList);
	}

	/**
	 * Gets a user by username
	 * @param username - username of user to search for
	 * @return response object containing message and user 
	 */
	@GetMapping("/User/{username}")
	public UserResponse getUser(@PathVariable String username) {
		List<User> list = new ArrayList<User>();
		User user = userRepository.findByUsername(username);
		String message;

		if (user != null) {
			list.add(user);
			message = "User found!";
		} else {
			message = "User not found";
		}

		return new UserResponse(message, list);
	}

	/**
	 * Creates a new user
	 * @param user - user object to create
	 * @return message string
	 * @throws InvalidAttributeValueException if field is null or integer
	 */
	@PostMapping(path = "/createUser", consumes = "application/json")
	public String createUser(@RequestBody User user) throws InvalidAttributeValueException {
		if (user.getFirstName() == null) {
			throw new InvalidAttributeValueException("firstName cannot be null or integer!");
		} else if (user.getLastName() == null) {
			throw new InvalidAttributeValueException("lastName cannot be null or integer!");
		} else if (user.getUsername() == null) {
			throw new InvalidAttributeValueException("username cannot be null or integer!");
		}

		userRepository.save(user);
		return String.format("User %s created!", user.getUsername());

	}

	/**
	 * Updates a user
	 * @param user - user object with updated fields
	 * @return response object containing message and updated user 
	 */
	@PutMapping(path = "/User", consumes = "application/json", produces = "application/json")
	public UserResponse updateUser(@RequestBody User user) {
		String username = user.getUsername();
		List<User> list = new ArrayList<User>();
		String message = "User updated!";
		User oldUser = userRepository.findByUsername(username);

		if (oldUser != null) {
			oldUser.setFirstName(user.getFirstName());
			oldUser.setLastName(user.getLastName());

			userRepository.save(oldUser);
			list.add(oldUser);
		} else {
			message = String.format("User %s not found!", user.getUsername());
		}

		return new UserResponse(message, list);
	}

	/**
	 * Delete a user
	 * @param username - username of user to delete
	 * @return
	 */
	@DeleteMapping(path = "/User/{username}")
	public UserResponse deleteUser(@PathVariable String username) {
		String id, message;
		User user = userRepository.findByUsername(username);
		if (user != null) {
			id = user.getId();
			userRepository.deleteById(id);
			message = String.format("User %s deleted!", user.getUsername());
		} else {
			message = String.format("User %s not found!", username);
		}

		return new UserResponse(message, userRepository.findAll());

	}

	/**
	 * Sort list of users by a given field and sort direction
	 * @param users - list of users
	 * @param field - field to sort list on
	 * @param direction - direction to sort list
	 * @return sorted user list
	 */
	public List<User> sortUsers(List<User> users, String field, String direction) {
		if (direction.compareToIgnoreCase("asc") == 0) {
			Collections.sort(users, (c1, c2) -> {
				switch (field.toUpperCase()) {
				case "USERNAME":
					return c1.getUsername().compareToIgnoreCase(c2.getUsername());
				case "FNAME":
					return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
				case "LNAME":
					return c1.getLastName().compareToIgnoreCase(c2.getLastName());
				default:
					throw new InvalidParameterException("sort field invalid");
				}
			});
		} else if (direction.compareToIgnoreCase("desc") == 0) {
			Collections.sort(users, (c1, c2) -> {
				switch (field.toUpperCase()) {
				case "USERNAME":
					return c2.getUsername().compareToIgnoreCase(c1.getUsername());
				case "FNAME":
					return c2.getFirstName().compareToIgnoreCase(c1.getFirstName());
				case "LNAME":
					return c2.getLastName().compareToIgnoreCase(c1.getLastName());
				default:
					throw new InvalidParameterException("sort field invalid");
				}
			});
		} else {
			throw new InvalidParameterException("sort value must be 'asc' or 'desc'.");
		}
		return users;
	}
}
