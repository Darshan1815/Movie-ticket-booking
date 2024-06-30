package com.ticketbooking.demo.cotrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Theater;
import com.ticketbooking.demo.service.TheaterService;

@RestController
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	
	
	@PostMapping("/api/add/theater")
	public Theater addTheater(@RequestBody Theater theater, @RequestHeader("Authorization") String jwt) {
		
		Theater savedTheater= theaterService.addTheater(theater);
		
		return savedTheater;
		
	}
	
	
	@GetMapping("/api/get/theater/{name}")
	public List<Screen> getTheater(@PathVariable String name, @RequestHeader("Authorization") String jwt) {
		
		List<Screen> savedScreen= theaterService.findByTheaterName(name);
		
		return savedScreen;
		
	}
	
	
}
