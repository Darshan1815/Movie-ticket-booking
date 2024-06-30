package com.ticketbooking.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Theater;
import com.ticketbooking.demo.repositories.ScreenRepository;
import com.ticketbooking.demo.repositories.TheaterRepository;
import com.ticketbooking.demo.service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService {
	
	@Autowired
	TheaterRepository theaterRepo;
	
	@Autowired
	ScreenRepository screenRepo;

	@Override
	public Screen addScreen(Screen screen, Integer theaterId) {
		
		Screen newScreen=new Screen();
		
		Theater theater= theaterRepo.findById(theaterId).get();
		
		newScreen.setScreenNumber(screen.getScreenNumber());
		
		newScreen.setCapacity(screen.getCapacity());
		
		newScreen.setTheater(theater);
		
		
		
		Screen savedScreen= screenRepo.save(newScreen);
		
		theater.getScreens().add(savedScreen);
		
		theaterRepo.save(theater);
		
		return savedScreen;
	}
	
	
	
	
	

}
