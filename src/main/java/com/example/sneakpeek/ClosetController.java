package com.example.sneakpeek;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sneakpeek.ItemRepository;

@RestController
public class ClosetController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostMapping(path = "/Closet", consumes = "application/json", produces = "application/json")
	public List<ClosetItem> addClosetItem(@RequestBody ClosetRequest closetReq) {
		String username = closetReq.getUsername();
		ClosetItem item = closetReq.getClosetItem();
		
		User user = userRepository.findByUserName(username);
		String userID = user.getId();
		
		ClosetItem newItem = new ClosetItem(userID, item.itemType, item.itemName, item.itemDescription, item.itemVisibility);
		itemRepository.save(newItem);

		return itemRepository.findByUserId(userID);
	}

	@GetMapping(path = "/Closet/{userName}")
	public List<ClosetItem> getCloset(@PathVariable String userName) {
		// return users closet where item visibility = true

		User user = userRepository.findByUserName(userName);
		List<ClosetItem> closet = itemRepository.findByUserId(user.getId());

		List<ClosetItem> visibleCloset = closet.stream().filter(c -> c.getItemVisibility() == true)
				.collect(Collectors.toList());

		return visibleCloset;
	}
}
