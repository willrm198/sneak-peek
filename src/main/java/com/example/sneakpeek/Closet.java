package com.example.sneakpeek;

import org.springframework.data.annotation.Id;
import java.util.*;

public class Closet {

	@Id
	public String id;

	private List<Item> closet;
	
	public Closet() {
		this.closet  = new ArrayList<Item>();
	}
	
}
