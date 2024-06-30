package com.ticketbooking.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.demo.entities.Movie;
import com.ticketbooking.demo.entities.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {

	
	
	public Theater findByName(String name);
	
	
}
