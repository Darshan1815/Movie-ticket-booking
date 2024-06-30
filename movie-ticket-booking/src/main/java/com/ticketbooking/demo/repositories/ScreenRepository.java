package com.ticketbooking.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Theater;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
	
	
	public List<Screen> findByTheater(Theater theater);
	

}
