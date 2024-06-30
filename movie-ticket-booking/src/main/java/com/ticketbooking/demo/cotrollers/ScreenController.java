package com.ticketbooking.demo.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.service.ScreenService;



@RestController
public class ScreenController {
	
	
	@Autowired
	ScreenService screenService;
	
	@PostMapping("api/addscreen/theater/{theaterId}")
	public Screen addScreen(@RequestBody Screen screen, @PathVariable Integer theaterId) {
		
		Screen savedScreen= screenService.addScreen(screen, theaterId);
		
		
		return savedScreen;
	}

}
