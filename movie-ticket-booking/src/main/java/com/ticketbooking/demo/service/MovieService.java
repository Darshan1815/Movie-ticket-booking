package com.ticketbooking.demo.service;

import java.util.List;

import com.ticketbooking.demo.entities.Movie;

public interface MovieService {

	
	public Movie addMovie(Movie movie, Integer showId);
	
	public List <Movie> findByTitle(String title);
}
