package com.ticketbooking.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.demo.entities.Movie;



public interface MoviesRepository extends JpaRepository<Movie, Integer> {
	
	
	public List <Movie> findByTitle(String title);

}
