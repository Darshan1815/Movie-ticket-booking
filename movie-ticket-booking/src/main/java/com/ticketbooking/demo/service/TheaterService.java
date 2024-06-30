package com.ticketbooking.demo.service;

import java.util.List;

import com.ticketbooking.demo.entities.Movie;
import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Theater;

public interface TheaterService {

	
	public Theater addTheater(Theater theater);
	
	public List<Screen> findByTheaterName(String name);
	
	
}
