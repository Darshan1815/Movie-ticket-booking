package com.ticketbooking.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.demo.entities.Movie;
import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Show;
import com.ticketbooking.demo.entities.Theater;
import com.ticketbooking.demo.repositories.ScreenRepository;
import com.ticketbooking.demo.repositories.ShowRepository;
import com.ticketbooking.demo.repositories.TheaterRepository;
import com.ticketbooking.demo.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	TheaterRepository theaterRepo;
	
	@Autowired
	ScreenRepository screenRepo;
	
	@Autowired
	ShowRepository showRepo;
	

	@Override
	public Theater addTheater(Theater theater) {
		
		Theater newTheater= new Theater();
		
		newTheater.setName(theater.getName());
		newTheater.setLocation(theater.getLocation());
		newTheater.setCity(theater.getCity());
		
		Theater savedTheater= theaterRepo.save(newTheater);
		
		return savedTheater;
	}


	@Override
	public List<Screen> findByTheaterName(String name) {

		 Theater theater = theaterRepo.findByName(name);
		 
		 List <Screen> screen= new ArrayList<>();
		 
		 if(theater!=null) {
		 
		  screen= screenRepo.findByTheater(theater);
		 }
		 
		 
		return screen;
	}
	
	
	

}
